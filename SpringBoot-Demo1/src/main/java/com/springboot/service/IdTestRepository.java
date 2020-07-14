package com.springboot.service;

import com.springboot.vo.IdTest;
import com.springboot.vo.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IdTestRepository extends JpaRepository<IdTest,Long> {

}
