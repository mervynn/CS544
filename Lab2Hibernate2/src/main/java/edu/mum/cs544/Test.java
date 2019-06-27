package edu.mum.cs544;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println((int) new Date().getTime());
        System.out.println((int) (new Date().getTime()/1000));

    }
}
