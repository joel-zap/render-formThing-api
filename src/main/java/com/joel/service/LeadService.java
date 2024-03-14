package com.joel.service;

import com.joel.model.Lead;

import java.util.List;

public interface LeadService {

    boolean saveLead(Lead lead);

    List<Lead> getLeads();

    void deleteLeadById(String id);

     Lead updateLead(Lead lead, String id);

    Lead getLeadById(String id);
}
