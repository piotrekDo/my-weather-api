package com.example.myweatherapi.mailing;

enum Mailbox {
    MAILBOX_REGISTER("pogodynka@piodom.com", "pogodynka"),
    MAILBOX_PASSWORD("pogodynka@piodom.com", "pogodynka");

    public String getAddress() {
        return address;
    }

    public String getPass() {
        return pass;
    }

    private final String address;
    private final String pass;

    Mailbox(String address, String pass) {
        this.address = address;
        this.pass = pass;
    }
}
