package service;

import lombok.RequiredArgsConstructor;
import model.Beat;
import org.springframework.stereotype.Service;
import repo.BeatRepo;

import java.util.List;

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
}
