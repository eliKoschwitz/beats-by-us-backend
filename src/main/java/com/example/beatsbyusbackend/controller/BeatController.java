package com.example.beatsbyusbackend.controller;

import lombok.RequiredArgsConstructor;
import com.example.beatsbyusbackend.model.Beat;
import org.springframework.web.bind.annotation.*;
import com.example.beatsbyusbackend.service.BeatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beats")
public class BeatController {

    private final BeatService beatService;

    @GetMapping
    public List<Beat> findAllBeat(){
        return beatService.findAllBeat();
    }

    @PostMapping
    public Beat saveBeat(@RequestBody Beat beat){
        return beatService.saveBeat(beat);
    }
}
