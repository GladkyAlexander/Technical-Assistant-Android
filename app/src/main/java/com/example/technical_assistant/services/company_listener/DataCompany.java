package com.example.technical_assistant.services.company_listener;

import com.example.technical_assistant.domain.Company;

public class DataCompany {
    private final Company company;

    public DataCompany(Company company) {
        this.company = company;
    }

    public Company getCompany(){
        return company;
    }

}
