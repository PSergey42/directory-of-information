package com.example.backend.controller;

import com.example.backend.service.ParticipantInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ParticipantInfoController {

    private final ParticipantInfoService participantInfoService;

    public ParticipantInfoController(ParticipantInfoService participantInfoService) {
        this.participantInfoService = participantInfoService;
    }
}
