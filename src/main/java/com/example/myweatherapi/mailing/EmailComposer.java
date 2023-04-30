package com.example.myweatherapi.mailing;

import com.example.myweatherapi.auth.RegisterRequest;
import org.springframework.stereotype.Component;

import static com.example.myweatherapi.mailing.Mailbox.MAILBOX_PASSWORD;
import static com.example.myweatherapi.mailing.Mailbox.MAILBOX_REGISTER;


@Component
public class EmailComposer {
    public void sendRegistrationMessage(RegisterRequest request) {
        EmailTemplate mail = new WelcomeEmail(request.getFirstName(), request.getLastName());
        String message = mail.create(request.getFirstName());

        EmailSender emailSender = new EmailSender(MAILBOX_REGISTER);
        emailSender.sendMail("Potwierdzenie rejestracji konta w serwisie Pogodynka",
                message,
                request.getEmail());
    }

//    public void sendResetPasswordToken(PasswordChangeRequestDto request, String token) {
//        EmailTemplate mail = new RequestPasswordResetEmail(token);
//        String message = mail.create(request.getUsername());
//
//        EmailSender emailSender = new EmailSender(MAILBOX_PASSWORD);
//        emailSender.sendMail("Zmiana hasła logowania w serwisie Pogodynka",
//                message,
//                request.getEmail());
//    }
//
//    public void sendPasswordChangeConformation(AppUser appUser) {
//        EmailTemplate mail = new PasswordChangedEmail();
//        String message = mail.create(appUser.getUsername());
//
//        EmailSender emailSender = new EmailSender(MAILBOX_PASSWORD);
//        emailSender.sendMail("Zmiana hasła logowania w serwisie Pogodynka",
//                message,
//                appUser.getUserEmail());
//    }

}
