package com.example.beatsbyusbackend.service;

import lombok.RequiredArgsConstructor;
import com.example.beatsbyusbackend.model.Beat;
import org.springframework.stereotype.Service;
import com.example.beatsbyusbackend.repo.BeatRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeatService {
    private final BeatRepo beatRepo;

    public List<Beat> findAllBeat() {
        return beatRepo.findAll();
    }

    public Beat saveBeat(Beat beat) {
        return beatRepo.save(beat);
    }

    public Optional<Beat> findById(String id) {
        return beatRepo.findById(id);
    }
}
