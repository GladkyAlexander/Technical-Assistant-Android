package com.example.technical_assistant.services.company_listener;

public interface SubjectCompany {
    void registerObserverCompany(ObserverCompany observerCompany);
    void unregisterObserverCompany(ObserverCompany observerCompany);
    void notifyObserversCompany();
}
