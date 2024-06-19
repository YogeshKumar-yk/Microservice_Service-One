package com.service.one.service;

import com.service.one.dto.EmployeeDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

//@FeignClient(name = "Employee-Service", url = "http://localhost:9090")
@FeignClient(name = "Employee-Service")
public interface EmployeeFeign {

    @GetMapping("/employee/{departmentId}")
    List<EmployeeDto> getListOfEmployees(@PathVariable("departmentId") Long departmentId);
}


