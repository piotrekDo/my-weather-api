package com.example.myweatherapi.mailing;


public class PasswordChangedEmail extends EmailTemplate {
    @Override
    String setMessage() {
        return "Twoje hasło zostało poprawnie zmienione";
    }
}
