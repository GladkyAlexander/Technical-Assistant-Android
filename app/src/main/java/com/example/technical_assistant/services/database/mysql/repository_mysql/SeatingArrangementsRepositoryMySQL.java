package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.SeatingArrangements;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface SeatingArrangementsRepositoryMySQL {
    List<SeatingArrangements> getSeatingArrangementsList(User user, String nameCompany);
    SeatingArrangements getSeatingArrangementsById(User user, Integer id);
    SeatingArrangements getSeatingArrangementsByName(User user, String name);
    Integer setSeatingArrangements(User user, SeatingArrangements seatingArrangements);
    void changeSeatingArrangements(SeatingArrangements seatingArrangements);
}
