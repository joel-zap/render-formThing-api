package com.joel.repository;


import com.joel.model.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface LeadRepository extends MongoRepository<Lead, String> {
}
