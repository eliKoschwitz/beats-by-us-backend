package com.example.beatsbyusbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beat {
    private String id;
    private String name;
    private int tempo;
    private List<BeatChain> beatList;
}
