package com.gara.es.req;

import lombok.Data;

/**
 * @author GARA
 * @description 查询请求参数
 * @date 2022/5/2 12:17
 */
@Data
public class SearchCondReq {

    private String keyword;

    private Integer pageSize = 10;

    private Integer pageNo = 1;
}
