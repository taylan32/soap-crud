package com.example.soapcrud.transformer;

import com.example.soapcrud.interfaces.AddEmployeeRequest;
import com.example.soapcrud.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeHelper {

    public Employee prepareEmployeeModel(AddEmployeeRequest request) {
        Employee employee = new Employee(
                request.getEmployeeInfo().getEmployeeId(),
                request.getEmployeeInfo().getName(),
                request.getEmployeeInfo().getDepartment(),
                request.getEmployeeInfo().getPhone(),
                request.getEmployeeInfo().getAddress()
        );
        return employee;
    }

}
