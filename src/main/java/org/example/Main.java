package org.example;

import java.util.List;

import data.DSizes;
import data.DUsuario;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        DSizes size = new DSizes();
        try {
            String sizes[] = size.findOne(3);
            if (sizes != null) {
                for (String string : sizes) {
                    System.out.println(string);
                }
            } else {
                System.out.println("No se encontró el tamaño con el ID proporcionado.");
            }
            // ! CREAR UN USUARIO
            // String message = user.guardar(
            // "Carlos Laime",
            // "carlos@gmail.com",
            // "123",
            // 75338090,
            // "av bolivia",
            // "Cliente");
            // System.out.println(message);
            // ! LISTA TODOS LOS USUARIO
            // List<String[]> message = user.listar();
            // for (String[] strings : message) {

            // for (String data : strings) {
            // System.out.println(String.valueOf(data));
            // }
            // }
            // ! OBTENER UN USUARIO
            // String [] userData = user.ver(3);
            // for (String datos : userData) {
            // System.out.println(datos);
            // }
            // ! MODIFICAR UN USUARIO
            // String userUpdate = user.modificar(
            //         3,
            //         "jorge balliviancito",
            //         "jorge@gmail.com",
            //         "123",
            //         7755,
            //         "av bolivia");
            // System.out.println(userUpdate);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

    }
}