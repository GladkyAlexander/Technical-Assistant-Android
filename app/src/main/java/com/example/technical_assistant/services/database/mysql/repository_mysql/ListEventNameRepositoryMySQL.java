package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.Events;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface ListEventNameRepositoryMySQL {
    void setEventName(User user, Events events);
    void setEventNameList(User user, List<Events> events, String nameCompany);
    List<String> getEventsNameList(User user, String companyName);
    void updateEventName(User user, Events events);
    void updateEventNameList(User user, List<Events> events);
}
