package com.service.one.service;

import com.service.one.dto.EmployeeDto;
import com.service.one.dto.RequestDto;
import com.service.one.dto.ResponseDto;
import com.service.one.entity.Department;
import com.service.one.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
    public class DepartmentService {

        @Autowired
        private DepartmentRepo departmentRepo;
        @Autowired
        private  EmployeeFeign employeeFeign;

        public List<EmployeeDto> getEmployeesByDeptId(long deptId) {

            return employeeFeign.getListOfEmployees(deptId);
        }
        public ResponseDto saveDepartment(RequestDto requestDto) {
        Department dept = new Department();
        dept.setDepartmentName(requestDto.getDepartmentName());
        dept.setDepartmentLocation(requestDto.getDepartmentLocation());
        Department savedDepartment = departmentRepo.save(dept);

        ResponseDto response = new ResponseDto();
        response.setDepartmentName(savedDepartment.getDepartmentName());
        response.setMessage("Department saved");

        return response;
        }
     public List<EmployeeDto> fallBackResponse() {
        EmployeeDto e = new EmployeeDto();
        e.setEmployeeId(null);
        e.setEmployeeName("Service down");
        e.setEmployeeMail("Service down");

        List list = new ArrayList();
        list.add(e);
        return list;
     }
    public List<Department> getAllDepartments() {
//        Optional<Department> byId = departmentRepo.findById(1L);
        List<Department> departmentList = departmentRepo.findAll();
        return departmentList;
    }

    public final void test(){

    }
    public final void test(int x){

    }

    public static final void test1(){}

    public static final void test1(int x){}

    public static  void test2(int x){}

    public static  void test2(){}

}
