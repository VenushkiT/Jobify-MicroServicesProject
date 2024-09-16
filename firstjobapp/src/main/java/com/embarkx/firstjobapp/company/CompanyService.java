package com.embarkx.firstjobapp.company;

import java.util.List;

public interface CompanyService {
    Company findByName(String name);
    Company save(Company company);
    Company update(Company company);
    void delete(Company company);
    List<Company> getAllCompanies();
}
