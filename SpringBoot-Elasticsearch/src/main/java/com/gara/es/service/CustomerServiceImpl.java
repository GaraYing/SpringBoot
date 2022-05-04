package com.gara.es.service;

import com.gara.es.model.Product;
import com.gara.es.req.SearchCondReq;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author GARA
 * @description
 * @date 2022/5/2 12:13
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public List<Product> search(SearchCondReq searchCondReq) throws IOException {
        SearchRequest searchRequest = new SearchRequest("products_new");
        BoolQueryBuilder bool = new BoolQueryBuilder();
        bool.should()
                .add(QueryBuilders.termQuery("description", searchCondReq.getKeyword()));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(false).field("description").field("title")
                .preTags("<span style='color:red;'>").postTags("</span>");
        SearchSourceBuilder searchSourceBuilder = SearchSourceBuilder.searchSource()
                .query(bool)
                .from(searchCondReq.getPageSize() * (searchCondReq.getPageNo() - 1))
                .size(searchCondReq.getPageSize())
                .sort("price", SortOrder.DESC)
                .fetchSource(new String[]{"title", "price", "description"}, new String[]{})
                .highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("response.getHits().getTotalHits().value = " + response.getHits().getTotalHits().value);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println("id:" + hit.getId() + "source: " + hit.getSourceAsString());
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
           /* highlightFields.entrySet().parallelStream().forEach(e -> {
                System.out.println("e.getKey() = " + e.getKey() + "e.getValue()" + e.getValue());
            });*/
            if (highlightFields.containsKey("title")) {
                System.out.println("highlightFields.get(\"title\").fragments()[0] = " + highlightFields.get("title").fragments()[0]);
            }
            if (highlightFields.containsKey("description")) {
                System.out.println("highlightFields.get(\"description\").fragments()[0] = " + highlightFields.get("description").fragments()[0]);
            }
        }
        return null;
    }
}
