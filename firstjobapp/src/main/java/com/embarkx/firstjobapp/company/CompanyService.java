package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {
    Company findByName(String name);
    Company save(Company company);
    boolean updateCompany(Company company, Long id);
    void delete(Company company);
    List<Company> getAllCompanies();
    void createCompany(Company company);
}
