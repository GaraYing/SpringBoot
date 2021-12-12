package com.gara.es.repository;

import com.gara.es.es.doc.CustomerDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author GARA
 */
@Repository
public interface CustomerDocRepository extends ElasticsearchRepository<CustomerDoc, Long> {
}
