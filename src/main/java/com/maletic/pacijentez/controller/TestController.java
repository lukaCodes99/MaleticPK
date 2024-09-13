package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.service.SmsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private SmsService smsService;

    public TestController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sms")
    public void sendSms() {
        try {
            smsService.sendSms();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
