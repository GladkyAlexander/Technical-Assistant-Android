package com.example.technical_assistant.services.database.mysql.repository_mysql;

import com.example.technical_assistant.domain.Room;
import com.example.technical_assistant.domain.User;

import java.util.List;

public interface RoomRepositoryMySQL {
    List<Room> getListRoomForCompany(User user, String companyName);
    Room getRoomByName(User user, String companyName, String roomName);
    void setRoom(Room room);
    void updateRoom(Room room);
}
