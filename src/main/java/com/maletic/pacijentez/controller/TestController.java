package com.maletic.pacijentez.controller;

import com.maletic.pacijentez.service.SmsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    private SmsService smsService;

    public TestController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sms")
    public void sendSms(@RequestParam String fullName) {
        try {
            smsService.sendSms(fullName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
