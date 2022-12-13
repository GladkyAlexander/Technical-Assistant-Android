package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.Company;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface CompanyRepositoryMySQL {
    List<Company> getListCompany(User user);
    Company getCompanyByName(User user,String nameCompany);
    void setCompany(User user, Company company);
    void updateCompany(User user, Company company);
}
