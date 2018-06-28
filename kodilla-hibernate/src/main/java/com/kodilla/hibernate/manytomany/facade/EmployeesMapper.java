package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.List;
import java.util.stream.Collectors;

class EmployeesMapper {

    private EmployeesMapper() {
        throw new IllegalStateException();
    }

    static List<EmployeeDto> mapToEmployeeDtoList(final List<Employee> employees) {
        return employees.stream()
                .map(e -> new EmployeeDto(e.getId(), e.getFirstname(), e.getLastname(), e.getCompanies()))
                .collect(Collectors.toList());
    }

}
