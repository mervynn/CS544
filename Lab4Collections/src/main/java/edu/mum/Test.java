package edu.mum;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        Laptop laptop2 = new Laptop();
        Set<Laptop> laps = new HashSet<Laptop>();
        laps.add(laptop1);
        laps.add(laptop2);
        System.out.println(laps.size());
        System.out.println(laptop1);
        System.out.println(laptop2);

        System.out.println((int) 0x4a574795);

    }
}
