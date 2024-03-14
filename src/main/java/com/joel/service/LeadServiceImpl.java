package com.joel.service;

import com.joel.model.Lead;
import com.joel.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public boolean saveLead(Lead lead) {
        try {
            Lead saveLead = leadRepository.save(lead);
            if (saveLead != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public List<Lead> getLeads() {
        return leadRepository.findAll();
    }

    @Override
    public void deleteLeadById(String id) {
        leadRepository.deleteById(id);
    }

    @Override
    public Lead updateLead(Lead lead, String id) {
        Lead upatedLead = null;

        lead.setId(id);
        upatedLead = leadRepository.save(lead);
        return upatedLead;
    }

    @Override
    public Lead getLeadById(String id) {
        Lead lead = null;
        try {
            lead = leadRepository.findById(id).orElse(lead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lead;
    }
}
