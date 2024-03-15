package com.joel.controller;

import com.joel.model.Lead;
import com.joel.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LeadController {
    @Autowired
    private LeadService leadService;

    // add new lead handler
    @CrossOrigin
    @PostMapping("/lead/save")
    public ResponseEntity<String> saveLead(@RequestBody Lead lead) {

        if (leadService.saveLead(lead)) {
//            return ResponseEntity.status(HttpStatus.OK).body("Lead Saved");
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lead not saved!!");
        }
    }

    // get all lead handler
    @CrossOrigin
    @GetMapping("/lead/getLeads")
    public ResponseEntity<List<Lead>> getLeads() {
        List<Lead> list = leadService.getLeads();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // update lead by id handler
    @CrossOrigin
    @PutMapping("/lead/updateLead/{id}")
    public ResponseEntity<Lead> updateLead(@RequestBody Lead lead, @PathVariable("id") String id) {
        try {
            Lead l = leadService.updateLead(lead, id);
            return ResponseEntity.ok().body(l);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // delete lead by id handler
    @CrossOrigin
    @DeleteMapping("/lead/deleteLead/{id}")
    public ResponseEntity<String> deleteLead(@PathVariable("id") String id) {
        try {
            leadService.deleteLeadById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Operation Unsuccessful!");
        }
    }

    // get lead by id handler
    @CrossOrigin
    @GetMapping("/lead/leadById/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable("id") String id) {
        Lead lead = leadService.getLeadById(id);
        if (lead == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(lead));
        }
    }
}
