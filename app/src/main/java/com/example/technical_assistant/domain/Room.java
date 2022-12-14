package com.example.technical_assistant.domain;

import android.provider.CalendarContract;

import java.util.List;

public class Room {
    int id;
    String nameRoom;
    String nameCompanyForRoom;
    List<Events> eventsList;
    List<SeatingArrangements> seatingArrangementsList;
    List<Equipment> equipmentList;
    List<Day> dayList;

    public Room() {
    }

    public Room(String nameRoom, String nameCompanyForRoom, List<Events> eventsList, List<SeatingArrangements> seatingArrangementsList, List<Equipment> equipmentList, List<Day> dayList) {
        this.nameRoom = nameRoom;
        this.nameCompanyForRoom = nameCompanyForRoom;
        this.eventsList = eventsList;
        this.seatingArrangementsList = seatingArrangementsList;
        this.equipmentList = equipmentList;
        this.dayList = dayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getNameCompanyForRoom() {
        return nameCompanyForRoom;
    }

    public void setNameCompanyForRoom(String nameCompanyForRoom) {
        this.nameCompanyForRoom = nameCompanyForRoom;
    }

    public List<Events> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<Events> eventsList) {
        this.eventsList = eventsList;
    }

    public List<SeatingArrangements> getSeatingArrangementsList() {
        return seatingArrangementsList;
    }

    public void setSeatingArrangementsList(List<SeatingArrangements> seatingArrangementsList) {
        this.seatingArrangementsList = seatingArrangementsList;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Day> getDayList() {
        return dayList;
    }

    public void setDayList(List<Day> dayList) {
        this.dayList = dayList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", nameRoom='" + nameRoom + '\'' +
                ", nameCompanyForRoom='" + nameCompanyForRoom + '\'' +
                ", eventsList=" + eventsList +
                ", seatingArrangementsList=" + seatingArrangementsList +
                ", equipmentList=" + equipmentList +
                ", dayList=" + dayList +
                '}';
    }
}
