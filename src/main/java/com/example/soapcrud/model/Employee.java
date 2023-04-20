package com.example.soapcrud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;


}
