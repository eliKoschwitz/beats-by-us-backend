package com.example.beatsbyusbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeatChain {
    private String name;
    private boolean[] pads = new boolean[8];
}
