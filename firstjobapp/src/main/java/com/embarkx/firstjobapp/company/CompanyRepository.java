package com.embarkx.firstjobapp.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);

    boolean existsById(Long id);
}
