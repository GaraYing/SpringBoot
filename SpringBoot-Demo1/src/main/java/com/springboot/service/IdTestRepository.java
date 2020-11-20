package com.springboot.service;

import com.springboot.vo.IdTest;
import org.springframework.data.repository.CrudRepository;

/**
 * {@link org.springframework.data.jpa.repository.JpaRepository}
 */
public interface IdTestRepository extends CrudRepository<IdTest,Long> {

}
