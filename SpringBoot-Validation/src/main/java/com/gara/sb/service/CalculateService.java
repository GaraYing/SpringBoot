package com.gara.sb.service;

/**
 * @description: 计算服务
 * @author:  GaraYing
 * @createTime: 2020/5/25 16:35
 * @Version: 1.0
**/
public interface CalculateService {

    /**
     * 多个Integer求和
     * @return
     */
    Integer sum(Integer ... values);
}
