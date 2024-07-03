package business;

import java.sql.SQLException;
import java.util.List;

import data.DOrders;

public class BOrders {
    private DOrders dOrders;

    public BOrders(){
        this.dOrders = new DOrders();
    }

    public String save(int total, int id_payment_method, int id_user, int id_state) {
        try {
            return dOrders.save(total, id_payment_method, id_user, id_state);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error saving order: " + e.getMessage();
        }
    }

    public List<String[]> findAllOrders() {
        try {
            return dOrders.findAllOrder();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
