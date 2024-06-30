package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PostgreSQL.databaseConnection;

public class DCategorie {

    private databaseConnection connection;

    public DCategorie() {
        
        this.connection = new databaseConnection(
            "postgres",
                "235364",
                "127.0.0.1",
                "5432",
                "db_pizza");
    }

    public void disconnect() {
        if (connection != null)
            connection.closeConnection();
    }



    public String save(String name) throws SQLException {
        String query = "INSERT INTO categories(name) values(?)";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setString(1, name);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DCategorie.java dice:" + "ocurrio un error al insertar una categoria");
            throw new SQLException();
        }
        return "se inserto con exito";
    }

    public String update(int id, String name) throws SQLException {
        String query = "UPDATE categories SET name=? WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, id);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DCategorie.java dice:" + "ocurrio un error al modificar una categoria");
            // throw new SQLException();
        }
        return "se modifico con exito";
    }

    public String delete(int id) throws SQLException {
        String query = "DELETE FROM categories WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DCategorie.java dice:" + "ocurrio un error al eliminar una categoria");
            // throw new SQLException();
        }
        return "se elimino con exito";
    }

    public List<String[]> findAll() throws SQLException {
        List<String[]> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            categories.add(new String[] {
                String.valueOf(set.getInt("id")),
                set.getString("name"),
            });
        }
        return categories;
    }
       
        
        public String[] findOne(int id) throws SQLException {
            String[] categories = null;
            String query = "SELECT * FROM categories WHERE id=?";
            PreparedStatement ps = connection.connection().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();
                if (set.next()) {
                categories = new String[] {
                    String.valueOf(set.getInt("id")),
                    set.getString("name")
                };
            }
            return categories;
        }

        public void closeConnection() {
            connection.closeConnection();
        }
}