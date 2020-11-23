package com.gara.jpademo.repository;

import com.gara.jpademo.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleExampleRepository extends JpaRepository<UserRole, Integer> {

}