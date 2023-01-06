package controller;

import lombok.RequiredArgsConstructor;
import model.Beat;
import org.springframework.web.bind.annotation.*;
import service.BeatService;

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
