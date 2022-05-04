package com.gara.es.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author GARA
 * @description TODO
 * @date 2022/5/4 10:56
 */
@Data
public class Product {
    private Long id;
    private String title;
    private Double price;
    @JSONField(name = "created_by")
    private String createdBy;
    @JSONField(name = "created_date")
    private LocalDateTime createdDate;
    private String description;
}
