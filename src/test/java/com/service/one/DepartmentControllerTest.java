package com.service.one;

import com.service.one.controller.DepartmentController;
import com.service.one.dto.RequestDto;
import com.service.one.dto.ResponseDto;
import com.service.one.entity.Department;
import com.service.one.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentController departmentController;

    @Test
    public void saveDepartmentTest(){

        ResponseDto responseDto = new ResponseDto();

        RequestDto requestDto = new RequestDto("dev", "chennai", "test");

        responseDto.setDepartmentName(requestDto.getDepartmentName());
        responseDto.setMessage("Saved");

        when(departmentService.saveDepartment(requestDto)).thenReturn(responseDto);

        ResponseEntity<ResponseDto> savedDepartment = departmentController.saveDepartment(requestDto);
        assertEquals(HttpStatus.CREATED, savedDepartment.getStatusCode());
        assertEquals(responseDto,savedDepartment.getBody());
    }

    @Test
    public void getListOfDepartmentsTest(){
        Department dept = new Department(1, "dev", "chennai");
        Department dept2 = new Department(2, "prod", "mumbai");
        Department dept3 = new Department(3, "QA", "Bangalore");

        List<Department> list = new ArrayList<>();
        list.add(dept);
        list.add(dept2);
        list.add(dept3);

        when(departmentService.getAllDepartments()).thenReturn(list);

        ResponseEntity<List<Department>> allDepartment = departmentController.getAllDepartment();

        assertEquals(HttpStatus.OK, allDepartment.getStatusCode());
        assertEquals(3, allDepartment.getBody().size());
        assertTrue(allDepartment.getBody().containsAll(list));
    }


}
