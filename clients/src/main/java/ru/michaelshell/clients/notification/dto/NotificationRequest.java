package ru.michaelshell.clients.notification.dto;

public record NotificationRequest(String email,
                                  String message,
                                  Integer userId) {
}
