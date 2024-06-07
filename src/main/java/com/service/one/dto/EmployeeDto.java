package com.service.one.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents an Employee entity")
public class EmployeeDto {

    @Schema(description = "Unique identifier of the employee", required = true)
    @NotNull
    private Long employeeId;

    @Schema(description = "Name of the employee")
    @Size(max = 45)
    private String employeeName;

    @Schema(description = "Email of the employee")
    @Size(max = 100)
    private String employeeMail;

//    public Long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Long employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(String employeeName) {
//        this.employeeName = employeeName;
//    }
//
//    public String getGetEmployeeMail() {
//        return getEmployeeMail;
//    }
//
//    public void setGetEmployeeMail(String getEmployeeMail) {
//        this.getEmployeeMail = getEmployeeMail;
//    }
}
