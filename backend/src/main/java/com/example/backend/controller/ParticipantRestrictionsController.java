package com.example.backend.controller;

import com.example.backend.service.ParticipantRestrictionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ParticipantRestrictionsController {

    private final ParticipantRestrictionsService participantRestrictionsService;

    public ParticipantRestrictionsController(ParticipantRestrictionsService participantRestrictionsService) {
        this.participantRestrictionsService = participantRestrictionsService;
    }
}
