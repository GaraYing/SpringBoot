package com.gara.es;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author GARA
 * @description TODO
 * @date 2022/4/23 18:52
 */
public class RestHighLevelClientTest extends EsDemoApplicationTests{

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

}
