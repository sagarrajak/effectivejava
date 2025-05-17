package com.effectivejava.practice;

import com.effectivejava.practice.enumstype.Planets;

public class Main {
    public static void main(String[] args) {
        for (Planets p : Planets.values()) {
            System.out.printf("%s %f%n", p, p.mass());
        }
        System.out.println(Planets.EARTH);
        System.out.println(Planets.JUPITER);
    }
}