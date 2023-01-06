package com.example.beatsbyusbackend.repo;

import com.example.beatsbyusbackend.model.Beat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeatRepo extends MongoRepository<Beat, String> {
}
