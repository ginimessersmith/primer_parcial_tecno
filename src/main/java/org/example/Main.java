package org.example;

import business.BCategorie;
import business.BState;

public class Main {
    public static void main(String[] args) {
        // BState bState = new BState();
        // String result = bState.save("Active");
        // System.out.println(result);
        BCategorie bCategorie = new BCategorie();
        String result = bCategorie.save("Pizza");
        System.out.println(result);
    }
}