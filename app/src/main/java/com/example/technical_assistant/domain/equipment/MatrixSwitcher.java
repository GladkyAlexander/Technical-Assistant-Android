package com.example.technical_assistant.domain.equipment;

import com.example.technical_assistant.domain.Defect;
import com.example.technical_assistant.domain.Equipment;

import java.time.LocalDate;
import java.util.List;

public class MatrixSwitcher extends Equipment {

    public MatrixSwitcher() {
    }

    public MatrixSwitcher(String name, String model, String manufacturer, String serialNumber, String macAddress, String macAddress1, String macAddress2,
                          String macAddress3, String login, String password, String image, String room, String location, LocalDate dateWork, String condition, String company, String manual, String ipAddress, String masc, String gateway, String danteIpAddress, String danteMasc, String danteGateway, String outletNumber, Integer portNumberInTheSwitch, Integer idNetworkSwitcher, List<Defect> defectList, Class<? extends Equipment> cl) {
        super(name, model, manufacturer, serialNumber, macAddress, macAddress1, macAddress2, macAddress3, login, password, image, room, location, dateWork, condition, company, manual, ipAddress, masc, gateway, danteIpAddress, danteMasc, danteGateway, outletNumber, portNumberInTheSwitch, idNetworkSwitcher, defectList, cl);
    }
}
