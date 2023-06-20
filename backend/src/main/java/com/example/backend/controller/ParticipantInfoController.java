package com.example.backend.controller;

import com.example.backend.entity.model.ParticipantInfoPojo;
import com.example.backend.service.ParticipantInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/participantInfo")
public class ParticipantInfoController {

    private final ParticipantInfoService participantInfoService;

    public ParticipantInfoController(ParticipantInfoService participantInfoService) {
        this.participantInfoService = participantInfoService;
    }

    @GetMapping("/all")
    public List<ParticipantInfoPojo> findAll(){
        return participantInfoService.findAll();
    }

    @GetMapping("/{uid}")
    public ParticipantInfoPojo getParticipantInfoByUID(@PathVariable("uid") long uid) {
        return participantInfoService.getParticipantInfoByUID(uid);
    }

    @PostMapping
    public ParticipantInfoPojo addParticipantInfo(@RequestBody ParticipantInfoPojo participantInfoPojo){
        return participantInfoService.addParticipantInfo(participantInfoPojo);
    }

    @PutMapping
    public ParticipantInfoPojo updateParticipantInfo(@RequestBody ParticipantInfoPojo participantInfoPojo){
        return participantInfoService.updateParticipantInfo(participantInfoPojo);
    }

    @DeleteMapping ("/{uid}")
    public void deleteParticipantInfo(@PathVariable("uid") long uid){
        participantInfoService.deleteParticipantInfo(uid);
    }
}
