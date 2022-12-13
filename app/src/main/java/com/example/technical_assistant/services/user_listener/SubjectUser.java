package com.example.technical_assistant.services.user_listener;

public interface SubjectUser {
    void registerObserverUser(ObserverUser observerUser);
    void unregisterObserverUser(ObserverUser observerUser);
    void notifyObserversUser();
}
