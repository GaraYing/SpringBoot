package com.gara.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author GARA
 */
@Configuration
public class EsRestClientConfigure extends AbstractElasticsearchConfiguration {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        CreateIndexResponse createIndexResponse = client.indices().create(new CreateIndexRequest("person_es"), RequestOptions.DEFAULT);
        System.out.println("createIndexResponse.isAcknowledged() = " + createIndexResponse.isAcknowledged());
        client.close();
    }

    @Value("${spring.elasticsearch.rest.uris:localhost:9200}")
    private String uris;
    @Value("${spring.elasticsearch.rest.username:9200}")
    private String username;
    @Value("${spring.elasticsearch.rest.password:9200}")
    private String password;


    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(uris).withBasicAuth(username, password).withHeaders(() -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("current_time", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            return httpHeaders;
        }).build();
        return RestClients.create(clientConfiguration).rest();
    }
}
