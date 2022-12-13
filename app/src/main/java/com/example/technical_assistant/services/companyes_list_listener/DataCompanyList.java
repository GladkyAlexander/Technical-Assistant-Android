package com.example.technical_assistant.services.companyes_list_listener;


import com.example.technical_assistant.domain.Company;

import java.util.List;

public class DataCompanyList {
    private final List<Company> companyes;

    public DataCompanyList(List<Company> companyList) {
        this.companyes = companyList;
    }

    public List<Company> getCompanyList(){
        return companyes;
    }

}
