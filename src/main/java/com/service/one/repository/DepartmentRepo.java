package com.service.one.repository;

import com.service.one.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
