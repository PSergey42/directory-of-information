package com.example.backend.controller;

import com.example.backend.entity.model.ParticipantRestrictionsPojo;
import com.example.backend.service.ParticipantRestrictionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/participantRestrictions")
public class ParticipantRestrictionsController {

    private final ParticipantRestrictionsService participantRestrictionsService;

    public ParticipantRestrictionsController(ParticipantRestrictionsService participantRestrictionsService) {
        this.participantRestrictionsService = participantRestrictionsService;
    }

    @GetMapping("/all")
    public List<ParticipantRestrictionsPojo> findAll(){
        return participantRestrictionsService.findAll();
    }

    @GetMapping("/{id}")
    public ParticipantRestrictionsPojo getParticipantRestrictionsByID(@PathVariable("id") long id) {
        return participantRestrictionsService.getParticipantRestrictionsByID(id);
    }

    @PostMapping("/{uid}")
    public ParticipantRestrictionsPojo addParticipantRestrictions(@RequestBody ParticipantRestrictionsPojo participantRestrictionsPojo, @PathVariable("uid") long uid){
        return participantRestrictionsService.addParticipantRestrictions(participantRestrictionsPojo, uid);
    }

    @PutMapping("/{uid}")
    public ParticipantRestrictionsPojo updateParticipantRestrictions(@RequestBody ParticipantRestrictionsPojo participantRestrictionsPojo, @PathVariable("uid") long uid){
        return participantRestrictionsService.updateParticipantRestrictions(participantRestrictionsPojo, uid);
    }

    @DeleteMapping ("/{id}")
    public void deleteParticipantRestrictions(@PathVariable("id") long id){
        participantRestrictionsService.deleteParticipantRestrictions(id);
    }
}
