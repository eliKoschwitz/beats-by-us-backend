package com.example.beatsbyusbackend.controller;

import lombok.RequiredArgsConstructor;
import com.example.beatsbyusbackend.model.Beat;
import org.springframework.web.bind.annotation.*;
import com.example.beatsbyusbackend.service.BeatService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beats")
public class BeatController {
    private final BeatService beatService;

    @GetMapping
    public List<Beat> findAllBeat(){
        return beatService.findAllBeat();
    }

    @GetMapping("/{id}")
    public Optional<Beat> findByID(@PathVariable String id ){
        return beatService.findById(id);
    }

    @PostMapping
    public Beat saveBeat(@RequestBody Beat beat){
        return beatService.saveBeat(beat);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id) {
        beatService.deleteByID(id);
    }
}
