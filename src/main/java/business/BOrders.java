package business;

import java.sql.SQLException;
import java.util.List;

import data.DOrders;
import data.DOrdersDetails;
import data.DPizzas;

public class BOrders {
    private DOrders dOrders;
    private DOrdersDetails dOrdersDetails;
    private DPizzas dPizzas;
    private int orderState;

    public BOrders(){
        this.dOrders = new DOrders();
        this.dPizzas = new DPizzas();
        this.dOrdersDetails = new DOrdersDetails();
        this.orderState = 1;
    }

    public String save(int id_user, int id_pizza, int pizzasQuantity, int id_payment_method) {
        try {
            Double pizzaPrice = this.dPizzas.getPrice(id_pizza);
            Double total = pizzaPrice * pizzasQuantity;
            int orderId = dOrders.save(total, id_payment_method, id_user, orderState);
            dOrdersDetails.save(pizzasQuantity, pizzaPrice, orderId, id_pizza);
            return "Orden ingresada con éxito";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrión un error al procesar el pedido: " + e.getMessage();
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

    public String updateOrderState(int orderId, int newStateId) {
        try {
            return dOrders.updateOrderState(orderId, newStateId);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Ocurrió un error al cambiar el estado de la orden: " + e.getMessage();
        }
    }
}
