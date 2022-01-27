package com.gara.es.repository;

import com.gara.es.es.doc.CustomerDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GARA
 */
@Repository
public interface CustomerDocRepository extends ElasticsearchRepository<CustomerDoc, Long> {

    /**
     * delete from customer where code = ''
     *
     * @param code
     */
    void deleteByCode(String code);

    /**
     * select * from customer where first_name like '' and last_name like ''
     *
     * @param lastName
     * @param firstName
     * @return
     */
    List<CustomerDoc> findCustomerDocByLastNameLikeAndFirstNameLike(String lastName, String firstName);
}
