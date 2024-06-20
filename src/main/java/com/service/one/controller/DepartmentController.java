package com.service.one.controller;

import com.service.one.dto.EmployeeDto;
import com.service.one.dto.RequestDto;
import com.service.one.dto.ResponseDto;
import com.service.one.entity.Department;
import com.service.one.service.DepartmentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DepartmentController {

    @Autowired
    public DepartmentService deptService;

    @RequestMapping("/{deptId}")
    @CircuitBreaker(name = "getEmpByDept", fallbackMethod = "getEmployeeByDeptFallBack")
    public ResponseEntity<List<EmployeeDto>>getEmployeeByDept(@PathVariable long deptId) {
            List<EmployeeDto> employeesByDeptId = deptService.getEmployeesByDeptId(deptId);
            return ResponseEntity.status(HttpStatus.OK).body(employeesByDeptId);
    }

    public ResponseEntity<List<EmployeeDto>>getEmployeeByDeptFallBack(
                                                         @PathVariable long deptId,
                                                         Throwable throwable) {
        System.out.print(throwable+ "----------------------fall back-------------------------------------");
        List<EmployeeDto> employeeDtoFallBack = deptService.fallBackResponse();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(employeeDtoFallBack);
    }
    @PostMapping("/saveDepartment")
    public ResponseEntity<ResponseDto> saveDepartment(@RequestBody RequestDto requestDto) {
         System.out.print( "----------------------yogesh-------------------------------------");
        System.out.print( "----------------------yogesh-------------------------------------");
        System.out.print( "----------------------yogesh-------------------------------------");
        
        ResponseDto responseDto = deptService.saveDepartment(requestDto);
        System.out.print( "----------------------yogesh-------------------------------------");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {

        List<Department> allDepartments = deptService.getAllDepartments();
        return new ResponseEntity<>(allDepartments, HttpStatus.OK);
    }

}
