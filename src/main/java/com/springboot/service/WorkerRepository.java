package com.springboot.service;

import com.springboot.vo.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Worker findByName(String name);

    Worker findByNameAndAge(String name, Integer age);

    @Query("FROM Worker w where w.name=:name")
    Worker findWorker(@Param("name") String name);
}
