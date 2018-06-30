package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    private final EmployeeDao employeeDao;
    private final CompanyDao companyDao;

    public Facade(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public List<EmployeeDto> getEmployeesWithNameIncluding(String excerpt) {
        return EmployeesMapper.mapToEmployeeDtoList(employeeDao.retrieveEmployeeByLastNameIncluding("%" + excerpt + "%"));
    }

    public List<CompanyDto> getCompaniesWithNameIncluding(String excerpt) {
        return CompaniesMapper.mapToCompanyDtoList(companyDao.retrieveCompaniesWithNameIncluding("%" + excerpt + "%"));
    }
}
