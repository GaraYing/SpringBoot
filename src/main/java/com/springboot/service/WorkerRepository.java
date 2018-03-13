package com.springboot.service;

import com.springboot.vo.User;
import com.springboot.vo.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkerRepository extends JpaRepository<User,Long> {

    Worker findByName(String name);

    Worker findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findWorker(@Param("name") String name);
}
