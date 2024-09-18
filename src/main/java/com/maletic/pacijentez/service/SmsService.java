package com.maletic.pacijentez.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    // Twilio Credentials from Twilio dashboard
    private static final String ACCOUNT_SID = "AC94055ba96e175c40a71c0e930b7dee43";
    private static final String AUTH_TOKEN = "7027066ba20032abb6dd9e6fe560c9ec";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public void sendSms(String body) {
        String to = "+385993327725";
        String poruka = "Lijepi pozdrav, " + body + "! "
                + "Hvala što ste posjetili Polikliniku Maletić! Bili bismo Vam zahvalni ako biste podijelili svoje iskustvo ostavljanjem recenzije "
                + "na sljedećoj poveznici: https://www.google.com/search?q=poliklinika+maletic"
                + "\n" + "Vaša Poliklinika Maletić";
        Message message = Message.creator(
                new PhoneNumber(to),  // To number
                new PhoneNumber("+13133297307"),  // From number
                poruka   // SMS body
        ).create();
        System.out.println("Message SID: " + message.getSid());
    }

}

