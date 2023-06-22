package com.example.backend.controller;

import com.example.backend.service.FileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@Log4j2
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/load")
    public ResponseEntity<?> parseXml(@RequestParam("file") MultipartFile file) {
        fileService.saveXmlInDataBase(file);
        log.info("Файл " + file.getOriginalFilename() + " успешно загружен");
        return ResponseEntity.ok().build();
    }
}
