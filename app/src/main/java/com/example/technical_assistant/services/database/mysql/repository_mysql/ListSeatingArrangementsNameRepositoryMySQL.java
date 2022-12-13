package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.SeatingArrangements;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface ListSeatingArrangementsNameRepositoryMySQL{
    void setSeatingArrangementsName(SeatingArrangements seatingArrangementsName);
    void setSeatingArrangementsNameList(User user, List<SeatingArrangements> seatingArrangements);
    List<String> getSeatingArrangementsNameList(User user, String companyName);
    SeatingArrangements getSeatingArrangementsName(String companyName, String SeatingArrangements);
    void updateSeatingArrangementsName(SeatingArrangements seatingArrangements);
    void updateSeatingArrangementsNameList(List<SeatingArrangements> seatingArrangements);
}
