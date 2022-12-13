package com.example.technical_assistant.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.technical_assistant.GlobalLinkMainController;
import com.example.technical_assistant.domain.Company;
import com.example.technical_assistant.domain.Equipment;
import com.example.technical_assistant.domain.User;
import com.example.technical_assistant.services.companyes_list_listener.DataCompanyList;
import com.example.technical_assistant.services.companyes_list_listener.HandlerCompanyListListener;
import com.example.technical_assistant.services.database.mysql.repository_mysql.CompanyRepositoryMySQL;
import com.example.technical_assistant.services.database.mysql.repository_mysql.impl.CompanyRepositoryMySQLImpl;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel{
    private MutableLiveData<Company> company;
    private MutableLiveData<List<Company>> companyes;
    private MutableLiveData<List<Equipment>> equipments;
    HandlerCompanyListListener handlerCompanyListListener = new HandlerCompanyListListener();
    User user;
    CompanyRepositoryMySQL companyRepositoryMySQL = new CompanyRepositoryMySQLImpl();
    


    private void loadCompany(){

        if(GlobalLinkMainController.getMainActivity().user != null) {
            this.user = GlobalLinkMainController.getMainActivity().user;
            if(user.getUserDB() != null) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Company> companyList = new ArrayList<Company>(companyRepositoryMySQL.getListCompany(user));
                            companyes.postValue(companyList);
                            handlerCompanyListListener.registerObserverCompanyList(GlobalLinkMainController.getMainActivity());
                            handlerCompanyListListener.onNewDataCompanyList(new DataCompanyList(companyList));
                        }
                });
                thread.start();
            }
        }

    }

    public LiveData<List<Company>> getListCompanyes() {
        if(companyes == null){
            companyes = new MutableLiveData<List<Company>>();
            loadCompany();
        }
        return companyes;
    }

    public LiveData<List<Equipment>> getEquipmentList(Company companyIn) {

        if(company == null){
            company = new MutableLiveData<Company>(companyIn);
        }

        if(equipments == null){
            equipments = new MutableLiveData<>();
            getEquipment();
        }
        return equipments;
    }

    private void getEquipment() {

        equipments.postValue(company.getValue().getEquipmentList());

    }

}