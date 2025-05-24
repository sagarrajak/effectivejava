package com.effectivejava.practice.enumstype;

import java.util.*;
import java.util.stream.Collectors;

public class DontUseOrdinal {
    public static void main(String[] args) {
        // Enum set example
        Set<Ensemble> exampleSet = EnumSet.allOf(Ensemble.class);
        exampleSet.remove(Ensemble.SOLO);
        boolean contains = exampleSet.contains(Ensemble.TRIO);
        System.out.println(contains);
        exampleSet.forEach(System.out::println);
        // enum map example
        Map<TrafficLight, String> signs = new HashMap<>();
        signs.put(TrafficLight.GREEN, "GO");
        signs.put(TrafficLight.YELLOW, "READY");
        signs.put(TrafficLight.RED, "STOP");
        Set<TrafficLight> keysSet = signs.keySet();
        Collection<String> valueSet = signs.values();
        Set<TrafficLight> collect = signs.entrySet().stream().map(s -> s.getKey()).collect(Collectors.toSet());
        System.out.println(collect);

    }
}

enum TrafficLight { RED, YELLOW, GREEN }

enum Ensemble {
    SOLO(1),
    DUET(2),
    TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8),
    NONET(9), DECTET(10);

    private final int numberOfMusicins;
    Ensemble(int numberOfMusicins) {
        this.numberOfMusicins = numberOfMusicins;
    }
    public int numberOfMusicians() { return numberOfMusicins; }

}
