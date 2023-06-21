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

    @GetMapping("/{id}")
    public BICDirectoryEntryPojo getBICDirectoryEntryByBIC(@PathVariable("id") long id) {
        return bicDirectoryEntryService.getBICDirectoryEntryByBIC(id);
    }

    @PostMapping("/{id}")
    public BICDirectoryEntryPojo addBICDirectoryEntry(@RequestBody BICDirectoryEntryPojo bicDirectoryEntryPojo, @PathVariable("id") long emailMessage_id){
        return bicDirectoryEntryService.addBICDirectoryEntry(bicDirectoryEntryPojo, emailMessage_id);
    }

    @PutMapping("/{id}")
    public BICDirectoryEntryPojo updateBICDirectoryEntry(@RequestBody BICDirectoryEntryPojo bicDirectoryEntryPojo, @PathVariable("id") long emailMessage_id){
        return bicDirectoryEntryService.updateBICDirectoryEntry(bicDirectoryEntryPojo, emailMessage_id);
    }

    @DeleteMapping ("/{id}")
    public void deleteBICDirectoryEntry(@PathVariable("id") long id){
        bicDirectoryEntryService.deleteBICDirectoryEntry(id);
    }
}
