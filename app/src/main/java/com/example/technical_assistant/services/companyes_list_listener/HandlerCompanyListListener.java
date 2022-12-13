package com.example.technical_assistant.services.companyes_list_listener;

import java.util.HashSet;
import java.util.Set;

public class HandlerCompanyListListener implements SubjectCompanyList {

    private DataCompanyList dataCompanyList;
    private Set<ObserverCompanyList> observerCompaniesList = new HashSet<>();

    public DataCompanyList getDataCompanyList(){
        return dataCompanyList;
    }
    public void onNewDataCompanyList(DataCompanyList newDataCompanyList){
        this.dataCompanyList = newDataCompanyList;
        notifyObserversCompanyList();
    }

    @Override
    public void registerObserverCompanyList(ObserverCompanyList observerCompanyList) {
        observerCompaniesList.add(observerCompanyList);
    }

    @Override
    public void unregisterObserverCompanyList(ObserverCompanyList observerCompanyList) {
        observerCompaniesList.remove(observerCompanyList);
    }

    @Override
    public void notifyObserversCompanyList() {
        for(ObserverCompanyList observerCompanyList : observerCompaniesList){
            observerCompanyList.updateCompanyList(dataCompanyList);
        }
    }
}
