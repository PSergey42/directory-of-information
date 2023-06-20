package com.example.backend.controller;

import com.example.backend.entity.model.SWBICPojo;
import com.example.backend.service.SWBICService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @GetMapping("/{bic}")
    public SWBICPojo getSWBICByBIC(@PathVariable("bic") String bic) {
        return swbicService.getSWBICByBIC(bic);
    }

    @PostMapping
    public SWBICPojo addSWBIC(@RequestBody SWBICPojo swbicPojo){
        return swbicService.addSWBIC(swbicPojo);
    }

    @PutMapping
    public SWBICPojo updateSWBIC(@RequestBody SWBICPojo swbicPojo){
        return swbicService.updateSWBIC(swbicPojo);
    }

    @DeleteMapping ("/{bic}")
    public void deleteSWBIC(@PathVariable("bic") String bic){
        swbicService.deleteSWBIC(bic);
    }
}
