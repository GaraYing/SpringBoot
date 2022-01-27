package com.gara.es.config;


import com.gara.sbcommon.CommonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonConfig.class)
public class EsCommonConfig {

    // https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.16.1/elasticsearch-analysis-ik-7.16.1.zip

    // https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.16.1/elasticsearch-analysis-ik-7.16.1.zip

    // https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.16.3/elasticsearch-analysis-ik-7.16.3.zip

    public EsCommonConfig() {
        System.out.println("===============common config");
    }
}