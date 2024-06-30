package org.example;

import java.util.List;

import data.DPaymentMethods;
import data.DSizes;
import data.DUsuario;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        DSizes size = new DSizes();
        DPaymentMethods payment = new DPaymentMethods(); 
        try {
            // ! find one size
            // String sizes[] = size.findOne(3);
            // if (sizes != null) {
            //     for (String string : sizes) {
            //         System.out.println(string);
            //     }
            // } else {
            //     System.out.println("No se encontró el tamaño con el ID proporcionado.");
            // }
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

            //! create payment
            // String createPayment = payment.createPayment("online");
            // System.out.println(createPayment);
            //! find all payments
            // List<String[]> allPayment = payment.findAllPayment();
            // for (String[] payments : allPayment) {
            //     for (String paymentsData : payments) {
            //         System.out.println(paymentsData);
            //     }
            // }
            //! find one payment
            // String[] onePayment = payment.findOnePayment(1);
            // for (String dataPayment : onePayment) {
            //     System.out.println(dataPayment);                
            // }
            //! update payment
            // String updatePayment = payment.updatePaymenet(1, "PayPal");
            // System.out.println(updatePayment);


        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

    }
}