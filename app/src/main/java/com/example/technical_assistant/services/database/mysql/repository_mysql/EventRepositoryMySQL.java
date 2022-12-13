package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.Events;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface EventRepositoryMySQL {
    Events getEventsForId(User user, Integer id);
    List<Events> getEventsForCompany(User user, String companyName);
    Events getEventsForNameIdDayEventStart(User user, String nameEvent, Integer idDay, String eventStartTime);
    Integer setEvent(User user, Events events);
    void updateEvent(User user,Events events);
}
