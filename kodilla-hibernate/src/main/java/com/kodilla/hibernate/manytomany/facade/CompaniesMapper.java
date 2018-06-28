package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;

import java.util.List;
import java.util.stream.Collectors;

class CompaniesMapper {

    private CompaniesMapper() {
        throw new IllegalStateException();
    }

    static List<CompanyDto> mapToCompanyDtoList(final List<Company> companies) {
        return companies.stream()
                .map(c -> new CompanyDto(c.getId(), c.getName(), c.getEmployees()))
                .collect(Collectors.toList());
    }
}
