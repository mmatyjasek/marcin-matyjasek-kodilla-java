package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.ArrayList;
import java.util.List;

class CompanyDto {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();


    CompanyDto(final int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
