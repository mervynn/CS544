package edu.mum.cs544;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>(){{
            add("1");
            add("2");
        }};
        System.out.println(a.get(2));
    }
}
