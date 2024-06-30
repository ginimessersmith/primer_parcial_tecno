package org.example;

import java.util.List;

import data.DPaymentMethods;
import data.DPizzas;
import data.DSizes;
import data.DState;
import data.DUsuario;
import data.DCategorie;
import data.DOrders;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        DSizes size = new DSizes();
        DUsuario user = new DUsuario();
        DState state = new DState();
        DPaymentMethods payment = new DPaymentMethods();
        DOrders orders = new DOrders();
        // DCategorie categories = new DCategorie();
        // DPizzas pizza = new DPizzas();
        try {
            // pizza.delete(3);
            // List<String[]> list = user.listar();
            // for (String[] strings : list) {
            // for (String dataUser : strings) {
            // System.out.println(dataUser);
            // }
            // }
            // ! create user
            // String createUser = user.guardar(
            // "Gino",
            // "gino@gmail.com",
            // "123456",
            // 75338090,
            // "av litoral",
            // "Administrativo");
            // System.out.println(createUser);
            // ! create state
            // String createState = state.save("Enviado");
            // System.out.println(createState);
            //! create payment 
            // String createPayment= payment.createPayment("Online");
            // System.out.println(createPayment);\
            //! create order
            // String createOrders = orders.save(10,1,1,1);
            // System.out.println(createOrders);
            //! find all order
            List<String[]> allOrders = orders.findAllOrder();
            for (String[] itemOrder : allOrders) {
                for (String itemData : itemOrder) {
                    System.out.println(itemData);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

    }
}