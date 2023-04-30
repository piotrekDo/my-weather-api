package com.example.myweatherapi.mailing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WelcomeEmail extends EmailTemplate {
    private final String firstName;
    private final String lastName;


    @Override
    String setMessage() {
        return String.format("""
                        <h1>%s witaj w serwisie Pogodynka</h1>
                        <h3>Twoje konto zostało poprawnie utworzone</h3>
                        <p>Zaloguj się .... tu będzie kiedyś link</p>
                """, firstName, lastName);
    }
}
