package com.example.soapcrud.service;

import com.example.soapcrud.interfaces.AddEmployeeRequest;
import com.example.soapcrud.interfaces.AddEmployeeResponse;
import com.example.soapcrud.interfaces.GetEmployeeRequest;
import com.example.soapcrud.interfaces.GetEmployeeResponse;
import com.example.soapcrud.model.Employee;

public interface EmployeeService {
    AddEmployeeResponse addEmployee(AddEmployeeRequest request);
    GetEmployeeResponse getEmployeeById(GetEmployeeRequest request);
    void deleteEmployee(long employeeId);
    void updateEmployee(Employee employee);
}
