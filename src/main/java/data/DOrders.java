package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import PostgreSQL.databaseConnection;

public class DOrders {

    public databaseConnection connection;
    ConfigDB ConfigDb = new ConfigDB();

    public DOrders() {

        this.connection = new databaseConnection(
                ConfigDb.getUser(),
                ConfigDb.getPassword(),
                ConfigDb.getHost(),
                ConfigDb.getPort(),
                ConfigDb.getDbName());
    }

    public void disconnect() {
        if (connection != null)
            connection.closeConnection();
    }

    public String save(int total, int id_payment_method, int id_user, int id_state) throws SQLException {
        String query = "INSERT INTO orders(total, created_at, update_at,id_payment_method,id_user,id_state) VALUES(?, ?, ?,?,?,?)";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        LocalDate now = LocalDate.now();
        ps.setInt(1, total);
        ps.setDate(2,  Date.valueOf(now)); // created_at
        ps.setDate(3, Date.valueOf(now));// updated_at
        ps.setInt(4, id_payment_method);
        ps.setInt(5, id_user);
        ps.setInt(6, id_state);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DOrders.java dice: ocurrió un error al insertar un pedido");
            throw new SQLException();
        }
        return "Se inserto con exito";
    }

    public List<String[]> findAllOrder()throws SQLException{
        List<String[]> orders = new ArrayList<>();
        String query = "SELECT * FROM orders;";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            orders.add(new String[]{
                String.valueOf(set.getInt("id")),
                String.valueOf(set.getInt("total")),
                set.getString("created_at"),
                set.getString("update_at"),
                String.valueOf(set.getInt("id_payment_method")),
                String.valueOf(set.getInt("id_user")),
                String.valueOf(set.getInt("id_state")),
            });
        }
        return orders;
        
    }

}
