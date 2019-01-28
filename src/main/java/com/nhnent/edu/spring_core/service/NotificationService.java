package com.nhnent.edu.spring_core.service;

public interface NotificationService {
    String getType();

    boolean sendNotification(String phoneNumber, String message);

}
