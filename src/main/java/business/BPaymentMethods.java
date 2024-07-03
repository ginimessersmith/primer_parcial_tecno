package business;

import java.sql.SQLException;
import java.util.List;

import data.DPaymentMethods;

public class BPaymentMethods {
    private DPaymentMethods dPaymentMethods;

    public BPaymentMethods() {
        this.dPaymentMethods = new DPaymentMethods();
    }

    
    public String createPayment(String name) {
        try {
            return dPaymentMethods.createPayment(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar el método de pago: " + e.getMessage();
        }
    }

    
    public String updatePayment(int id, String name) {
        try {
            return dPaymentMethods.updatePayment(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el método de pago: " + e.getMessage();
        }
    }

    
    public String delete(int id) {
        try {
            return dPaymentMethods.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el método de pago: " + e.getMessage();
        }
    }

   
    public List<String[]> findAllPayments() {
        try {
            return dPaymentMethods.findAllPayment();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

   
    public String[] findOnePayment(int id) {
        try {
            return dPaymentMethods.findOnePayment(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
