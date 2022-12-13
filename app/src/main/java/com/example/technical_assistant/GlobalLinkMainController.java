package com.example.technical_assistant;

public class GlobalLinkMainController {
    public static MainActivity mainController;

    private GlobalLinkMainController(){

    }

    public static MainActivity getMainActivity(){
        return mainController;
    }
    public static void setMainActivity(MainActivity mainController){
        GlobalLinkMainController.mainController = mainController;
    }
}
