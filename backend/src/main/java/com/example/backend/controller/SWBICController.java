package com.example.backend.controller;

import com.example.backend.service.SWBICService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class SWBICController {

    private final SWBICService swbicService;

    public SWBICController(SWBICService swbicService) {
        this.swbicService = swbicService;
    }
}
