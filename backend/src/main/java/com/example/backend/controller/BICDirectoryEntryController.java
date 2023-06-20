package com.example.backend.controller;

import com.example.backend.entity.model.BICDirectoryEntryPojo;
import com.example.backend.service.BICDirectoryEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/bicDirectoryEntry")
public class BICDirectoryEntryController {

    private final BICDirectoryEntryService bicDirectoryEntryService;

    public BICDirectoryEntryController(BICDirectoryEntryService bicDirectoryEntryService) {
        this.bicDirectoryEntryService = bicDirectoryEntryService;
    }

    @GetMapping("/all")
    public List<BICDirectoryEntryPojo> findAll(){
        return bicDirectoryEntryService.findAll();
    }

    @GetMapping("/{bic}")
    public BICDirectoryEntryPojo getBICDirectoryEntryByBIC(@PathVariable("bic") int bic) {
        return bicDirectoryEntryService.getBICDirectoryEntryByBIC(bic);
    }

    @PostMapping
    public BICDirectoryEntryPojo addBICDirectoryEntry(@RequestBody BICDirectoryEntryPojo bicDirectoryEntryPojo){
        return bicDirectoryEntryService.addBICDirectoryEntry(bicDirectoryEntryPojo);
    }

    @PutMapping
    public BICDirectoryEntryPojo updateBICDirectoryEntry(@RequestBody BICDirectoryEntryPojo bicDirectoryEntryPojo){
        return bicDirectoryEntryService.updateBICDirectoryEntry(bicDirectoryEntryPojo);
    }

    @DeleteMapping ("/{bic}")
    public void deleteBICDirectoryEntry(@PathVariable("bic") int bic){
        bicDirectoryEntryService.deleteBICDirectoryEntry(bic);
    }
}
