package com.gara.es.service;

import com.gara.es.model.Product;
import com.gara.es.req.SearchCondReq;

import java.io.IOException;
import java.util.List;

/**
 * @author GARA
 * @description TODO
 * @date 2022/5/2 12:13
 */
public interface CustomerService {

    /**
     * @param searchCondReq
     * @return
     */
    List<Product> search(SearchCondReq searchCondReq) throws IOException;
}
