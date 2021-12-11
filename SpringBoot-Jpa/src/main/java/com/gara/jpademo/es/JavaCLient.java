package com.gara.jpademo.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author GARA
 */
public class JavaCLient {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));


        CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("person_es"), RequestOptions.DEFAULT);

        System.out.println("c  reateIndexResponse.isAcknowledged() = " + createIndexResponse.isAcknowledged());

        client.close();
    }
}
