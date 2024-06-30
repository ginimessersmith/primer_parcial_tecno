package org.example;

import java.util.List;

import data.DPaymentMethods;
import data.DPizzas;
import data.DSizes;
import data.DUsuario;
import data.DCategorie;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        DSizes size = new DSizes();
        DUsuario user = new DUsuario();
        DCategorie categories = new DCategorie();
        DPizzas pizza = new DPizzas();
        try {
            pizza.delete(3);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

    }
}