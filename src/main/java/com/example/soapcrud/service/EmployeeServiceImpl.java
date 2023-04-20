package com.example.soapcrud.service;

import com.example.soapcrud.interfaces.*;
import com.example.soapcrud.model.Employee;
import com.example.soapcrud.repository.EmployeeRepository;
import com.example.soapcrud.transformer.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl  implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeHelper employeeHelper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeHelper employeeHelper) {
        this.employeeRepository = employeeRepository;
        this.employeeHelper = employeeHelper;
    }

    @Override
    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
        Employee employee = employeeHelper.prepareEmployeeModel(request);
        Employee createdEmployee = employeeRepository.save(employee);
        AddEmployeeResponse response = new AddEmployeeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content added successfully");
        EmployeeInfo employeeInfo = setEmployeeInfo(createdEmployee);
        response.setEmployeeInfo(employeeInfo);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @Override
    public GetEmployeeResponse getEmployeeById(GetEmployeeRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeInfo().getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found."));
        GetEmployeeResponse response = new GetEmployeeResponse();
        EmployeeInfo employeeInfo = setEmployeeInfo(employee);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    private EmployeeInfo setEmployeeInfo(Employee employee) {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setEmployeeId(employee.getEmployeeId());
        employeeInfo.setName(employee.getName());
        employeeInfo.setDepartment(employee.getDepartment());
        employeeInfo.setAddress(employee.getAddress());
        employeeInfo.setPhone(employee.getPhone());
        return employeeInfo;
    }
}
