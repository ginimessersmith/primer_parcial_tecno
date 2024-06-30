package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PostgreSQL.databaseConnection;

public class DPaymentMethods {

    public databaseConnection connection;

    public DPaymentMethods(){

        this.connection = new databaseConnection(
                "postgres",
                "ginimessersmith123456",
                "127.0.0.1",
                "5432",
                "db_pizzeria");
    }

    public void disconnect() {
        if (connection != null)
            connection.closeConnection();
    }

    public String createPayment(
        String name
    ) throws SQLException {
        String query = "INSERT INTO payment_methods(name) "
                + "values(?)";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setString(1, name);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DPayment.java dice:" + "ocurrio un error al insertar");
            return "error al crear";
            // throw new SQLException();
        }

        return "se inserto con exito";
    }

    public String[] findOnePayment(int id) throws SQLException{
        
        String[] payment = null;
        String query = "SELECT  * FROM payment_methods WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);

        ResultSet set = ps.executeQuery();
        if(set.next()){
            payment = new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name"),
            };
        }
        return payment;

    }

    public List<String[]> findAllPayment()throws SQLException {
        List<String[]> allPayments = new ArrayList<>();
        String query = "SELECT * FROM payment_methods";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            allPayments.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("name")
            });
        }

        return allPayments;
    }

    public String delete(int id) throws SQLException{
        String query = "DELETE FROM payment_methods WHERE id=?";
        String deletePayment="eliminado con exito";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 0) {
            System.err.println("Class DPayment.java dice: "
            + "Ocurrió un error, eliminar()");
            return "no se pudo eliminar ";
            // throw new SQLException();
        }
        return deletePayment;
    }

    public String updatePaymenet(int id, String name)throws SQLException{
        String query = "UPDATE payment_methods SET name=? WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, id);

        if(ps.executeUpdate()==0){
            System.out.println("error al actualizar");
            return "erro al actualizar un payment";
        }

        return "se actualizo con exito";
    }

}
