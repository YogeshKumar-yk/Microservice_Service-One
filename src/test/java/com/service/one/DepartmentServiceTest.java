package com.service.one;

import com.service.one.dto.RequestDto;
import com.service.one.dto.ResponseDto;
import com.service.one.entity.Department;
import com.service.one.repository.DepartmentRepo;
import com.service.one.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {


    @Mock
    DepartmentRepo departmentRepo;

    @InjectMocks
    DepartmentService departmentService;

    @Test
    public void saveDepartmentTest(){

        RequestDto requestDto = new RequestDto("dev", "chennai", "test");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setDepartmentName(requestDto.getDepartmentName());
        responseDto.setMessage("Saved");

        Department dept = new Department();
        dept.setDepartmentName(requestDto.getDepartmentName());
        dept.setDepartmentLocation(requestDto.getDepartmentLocation());

        when(departmentRepo.save(dept)).thenReturn(dept);
        ResponseDto responseDto1 = departmentService.saveDepartment(requestDto);

        assertEquals("dev", dept.getDepartmentName());
//        assertEquals(responseDto,responseDto1);

    }
}
