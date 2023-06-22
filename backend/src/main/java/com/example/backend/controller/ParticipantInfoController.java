package com.example.backend.controller;

import com.example.backend.entity.model.ParticipantInfoPojo;
import com.example.backend.service.ParticipantInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping("/{bic}")
    public ParticipantInfoPojo addParticipantInfo(@RequestBody ParticipantInfoPojo participantInfoPojo, @PathVariable("bic") int bic){
        return participantInfoService.addParticipantInfo(participantInfoPojo, bic);
    }

    @PutMapping("/{bic}")
    public ParticipantInfoPojo updateParticipantInfo(@RequestBody ParticipantInfoPojo participantInfoPojo, @PathVariable("bic") int bic){
        return participantInfoService.updateParticipantInfo(participantInfoPojo, bic);
    }

    @DeleteMapping ("/{uid}")
    public void deleteParticipantInfo(@PathVariable("uid") long uid){
        participantInfoService.deleteParticipantInfo(uid);
    }
}
