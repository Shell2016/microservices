package ru.michaelshell.customer.dto;

public record CustomerRegisterRequest(String firstName,
                                      String lastName,
                                      String email) {
}
