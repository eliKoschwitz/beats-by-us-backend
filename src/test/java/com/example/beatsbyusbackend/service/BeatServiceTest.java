package com.example.beatsbyusbackend.service;

import com.example.beatsbyusbackend.model.Beat;
import com.example.beatsbyusbackend.model.BeatChain;
import com.example.beatsbyusbackend.repo.BeatRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BeatServiceTest {

    private Beat createBeat() {
        boolean[] arrayPads = new boolean[]{true, true, true, true, true, true, true, true};

        List<BeatChain> beatChain = new ArrayList<>();
        beatChain.add(new BeatChain("BeatChain1", arrayPads));

        return new Beat("1", "Beat1", 120, beatChain);

    }

    @Test
    void getBeatByID_whenIDExist_ThenReturnBeat() {
        //given
        Beat beat = createBeat();
        BeatRepo beatRepo = Mockito.mock(BeatRepo.class);
        BeatService beatService = new BeatService(beatRepo);

        Mockito.when(beatRepo.findById(beat.getId())).thenReturn(Optional.of(beat));

        //when
        Optional<Beat> actual = beatService.findById(beat.getId());

        //then
        Assertions.assertEquals(actual, Optional.of(beat));

        Mockito.verify(beatRepo).findById(beat.getId());
    }

    @Test
    void deleteBeatByID_whenIDExist_ThenDeleteBeat() {
        //given
        Beat beat = createBeat();
        BeatRepo beatRepo = Mockito.mock(BeatRepo.class);
        BeatService beatService = new BeatService(beatRepo);

        Mockito.when(beatRepo.findById(beat.getId())).thenReturn(Optional.of(beat)).thenReturn(null);

        //when
        beatService.findById(beat.getId());
        beatService.deleteByID(beat.getId());
        Optional<Beat> actual = beatService.findById(beat.getId());

        //then
        Assertions.assertNull(actual);
        Mockito.verify(beatRepo).deleteById(beat.getId());
    }
}