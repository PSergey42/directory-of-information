package com.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class FileController {

    private final FileController fileController;

    public FileController(FileController fileController) {
        this.fileController = fileController;
    }
}
