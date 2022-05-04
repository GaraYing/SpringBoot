package com.gara.es;

import com.gara.es.model.Product;
import com.gara.es.req.SearchCondReq;
import com.gara.es.service.CustomerService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedDoubleTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.ParsedSum;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author GARA
 * @description TODO
 * @date 2022/4/23 18:52
 */
public class RestHighLevelClientTest extends EsDemoApplicationTests {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void createIndexAndMapping() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("products_new");
        createIndexRequest.mapping("{\n" +
                "  \"properties\": {\n" +
                "    \"id\": {\n" +
                "      \"type\": \"long\"\n" +
                "    },\n" +
                "    \"title\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    },\n" +
                "    \"price\": {\n" +
                "      \"type\": \"double\"\n" +
                "    },\n" +
                "    \"created_by\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"created_date\": {\n" +
                "      \"type\": \"date\"\n" +
                "    },\n" +
                "    \"description\": {\n" +
                "      \"type\": \"text\",\n" +
                "      \"analyzer\": \"ik_max_word\"\n" +
                "    }\n" +
                "  }\n" +
                "}", XContentType.JSON);

        CreateIndexResponse response = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println("response.isAcknowledged() = " + response.isAcknowledged());
    }

    @Test
    void testDelIndices() throws IOException {
        AcknowledgedResponse response = restHighLevelClient.indices().delete(new DeleteIndexRequest("orders"), RequestOptions.DEFAULT);
        System.out.println("response.isAcknowledged() = " + response.isAcknowledged());
    }

    @Resource
    private CustomerService customerService;

    @Test
    void testSearch() {
        SearchCondReq req = new SearchCondReq();
        req.setKeyword("手机");
        try {
            List<Product> products = customerService.search(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCreate() throws IOException {
        IndexRequest indexRequest = new IndexRequest("products_new");
        String jsonValue = "{\"title\":\"苹果14\",\"price\":5000.99,\"created_by\":\"Stiven乔布斯\",\"created_date\":\"2022-04-08\",\"description\":\"这个手机比安卓好用\"}";
        /**
         * note that@<code>XContentType.JSON</code> should be the second parameter
         */
        indexRequest.id("3")
                .source(jsonValue, XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println("indexResponse.status() = " + indexResponse.status());
    }

    @Test
    void testUpdate() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("products_new", "2");
        // Product product = new Product();
        // product.setTitle("小米15");
        // updateRequest.doc(new ObjectMapper().writeValueAsString(product), XContentType.JSON);
        updateRequest.doc("{\"title\":\"苹果100\"}", XContentType.JSON);
        UpdateResponse updateResponse = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println("updateResponse.getGetResult() = " + updateResponse.getGetResult());
    }


    /**
     * query: 精确查询，查询会计算得分，并根据文档得分排序返回
     * filter Query: 过滤查询，用来在大量数据中查询相关数据，不会计算得分，经常使用filter query 进行缓存
     * 注意：一旦同时使用filter query 和 query ，ES优先执行filer query再执行query
     *
     * @throws IOException
     */
    @Test
    void testFilterQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("products_new");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.termQuery("title", "苹果"))
                .must(QueryBuilders.rangeQuery("price").gt(1000).lt(6000));
        searchSourceBuilder.query(QueryBuilders.matchAllQuery())
                .postFilter(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("response.getHits().getTotalHits() = " + response.getHits().getTotalHits());
    }

    @Test
    void testAggregate() throws IOException {
        SearchRequest searchRequest = new SearchRequest("products_new");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        // 聚合处理
        searchSourceBuilder.aggregation(AggregationBuilders.terms("price_group").field("price"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        ParsedDoubleTerms priceGroup = response.getAggregations().get("price_group");
        for (Terms.Bucket bucket : priceGroup.getBuckets()) {
            System.out.println("bucket.getKey() = " + bucket.getKey());
            System.out.println("bucket.getDocCount() = " + bucket.getDocCount());
        }
    }

    @Test
    void testAggregateFunction() throws IOException {
        SearchRequest searchRequest = new SearchRequest("products_new");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        // 聚合处理
        searchSourceBuilder.aggregation(AggregationBuilders.sum("price_sum").field("price"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        ParsedSum parsedSum = response.getAggregations().get("price_sum");
        System.out.println("parsedSum.getValue() = " + parsedSum.getValue());
    }
}
