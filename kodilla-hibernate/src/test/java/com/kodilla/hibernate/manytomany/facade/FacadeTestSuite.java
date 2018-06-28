package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {

    private static final String COMP_EXC = "Soft";
    private static final String EMPLOYEE_EXC = "ov";

    private int id1, id2, id3, id4, id5;
    @Autowired
    Facade facade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Before
    public void inputData() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee johnKovalsky = new Employee("John", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company softwareMakers = new Company("Software Makers");
        Company softDev = new Company("Soft Dev");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        softwareMakers.getEmployees().add(johnKovalsky);
        softwareMakers.getEmployees().add(lindaKovalsky);
        softDev.getEmployees().add(stephanieClarckson);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        stephanieClarckson.getCompanies().add(softDev);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        lindaKovalsky.getCompanies().add(softwareMakers);
        johnKovalsky.getCompanies().add(softwareMakers);

        companyDao.save(softwareMachine);
        id1 = softwareMachine.getId();
        companyDao.save(dataMaesters);
        id2 = dataMaesters.getId();
        companyDao.save(greyMatter);
        id3 = greyMatter.getId();
        companyDao.save(softwareMakers);
        id4 = softwareMakers.getId();
        companyDao.save(softDev);
        id5 = softDev.getId();

    }

    @After
    public void clenUp() {
        try {
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
            companyDao.deleteById(id4);
            companyDao.deleteById(id5);
        } catch (Exception e) {
            //do nothing
        }
    }


    @Test
    public void shouldGetAllCompaniesWithNameIncludingExcerpt() {
        //Given

        //When
        List<CompanyDto> companies = facade.getCompaniesWithNameIncluding(COMP_EXC);

        //Then
        Assert.assertEquals(3, companies.size());
    }

    @Test
    public void shouldGetAllEmployeesWithLastnameIncludingExcerpt() {
        //Given

        //When
        List<EmployeeDto> employees = facade.getEmployeesWithNameIncluding(EMPLOYEE_EXC);

        //Then
        Assert.assertEquals(2, employees.size());
    }
}
