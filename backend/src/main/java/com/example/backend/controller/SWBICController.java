package com.example.backend.controller;

import com.example.backend.entity.model.SWBICPojo;
import com.example.backend.service.SWBICService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/swBIC")
public class SWBICController {

    private final SWBICService swbicService;

    public SWBICController(SWBICService swbicService) {
        this.swbicService = swbicService;
    }

    @GetMapping("/all")
    public List<SWBICPojo> findAll(){
        return swbicService.findAll();
    }

    @GetMapping("/{id}")
    public SWBICPojo getSWBICByID(@PathVariable("id") long id) {
        return swbicService.getSWBICByID(id);
    }

    @PostMapping("/{id}")
    public SWBICPojo addSWBIC(@RequestBody SWBICPojo swbicPojo, @PathVariable("id") long id){
        return swbicService.addSWBIC(swbicPojo, id);
    }

    @PutMapping("/{id}")
    public SWBICPojo updateSWBIC(@RequestBody SWBICPojo swbicPojo, @PathVariable("id") long id){
        return swbicService.updateSWBIC(swbicPojo, id);
    }

    @DeleteMapping ("/{id}")
    public void deleteSWBIC(@PathVariable("id") long id){
        swbicService.deleteSWBIC(id);
    }
}
