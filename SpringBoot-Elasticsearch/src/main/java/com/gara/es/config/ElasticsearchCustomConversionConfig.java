package com.gara.es.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;

import java.sql.Timestamp;

@Configuration
public class ElasticsearchCustomConversionConfig {


//    @Bean
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        return new ElasticsearchCustomConversions(
//                Arrays.asList(new TimestampToLong(), new LongToTimestamp()));
//    }

    @Bean
    public ElasticsearchConverter elasticsearchConverter(SimpleElasticsearchMappingContext mappingContext, ElasticsearchCustomConversions elasticsearchCustomConversions) {
        MappingElasticsearchConverter mappingElasticsearchConverter = new MappingElasticsearchConverter(mappingContext);
        mappingElasticsearchConverter.setConversions(elasticsearchCustomConversions);
        return mappingElasticsearchConverter;
    }

    @WritingConverter
    static class TimestampToLong implements Converter<Timestamp, Long> {
        @Override
        public Long convert(Timestamp source) {
            return source.getTime();
        }
    }

    @ReadingConverter
    static class LongToTimestamp implements Converter<Long, Timestamp> {
        @Override
        public Timestamp convert(Long source) {
            return new Timestamp(source);
        }
    }
}
