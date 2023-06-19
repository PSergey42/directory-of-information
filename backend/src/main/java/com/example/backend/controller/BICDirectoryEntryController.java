package com.example.backend.controller;

import com.example.backend.service.BICDirectoryEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class BICDirectoryEntryController {

    private final BICDirectoryEntryService bicDirectoryEntryService;

    public BICDirectoryEntryController(BICDirectoryEntryService bicDirectoryEntryService) {
        this.bicDirectoryEntryService = bicDirectoryEntryService;
    }
}
