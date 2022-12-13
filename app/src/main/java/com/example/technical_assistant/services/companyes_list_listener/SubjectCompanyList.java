package com.example.technical_assistant.services.companyes_list_listener;

public interface SubjectCompanyList {
    void registerObserverCompanyList(ObserverCompanyList observerCompanyList);
    void unregisterObserverCompanyList(ObserverCompanyList observerCompanyList);
    void notifyObserversCompanyList();
}
