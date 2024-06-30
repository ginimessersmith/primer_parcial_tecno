package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PostgreSQL.databaseConnection;

public class DUsuario {
    public databaseConnection connection;

    public DUsuario() {
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

    // id, name, email, password, phone, address
    public String guardar(
            String name,
            String email,
            String password,
            int phone,
            String address) throws SQLException {

        String query = "INSERT INTO users(name,email,password,phone,address) "
                + "values(?,?,?,?,?)";

        PreparedStatement ps = connection.connection().prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setInt(4, phone);
        ps.setString(5, address);

        if (ps.executeUpdate() == 0) {
            System.err.println("class DUsuario.java dice:" + "ocurrio un error al insertar un usuario");
            throw new SQLException();
        }

        return "se inserto con exito";
    }

    public String modificar(int id, String name, String email, String password,
            int phone, String address) throws SQLException {

        String query = "UPDATE users SET name=?, email=?,password=?, phone=?, address=? WHERE id=?";

        PreparedStatement ps = connection.connection().prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setInt(4, phone);
        ps.setString(5, address);
        ps.setInt(6, id);

        if (ps.executeUpdate() == 0) {
            System.err.println("class DUsuario.java dice:" + "ocurrio un error al modificar un usuario");
            return "error al actualizar";
            // throw new SQLException();
        }
        return "se actualizo con exito";
    }

    public String eliminar(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 0) {
            System.err.println("Class DUsuario.java dice: "
                    + "Ocurrió un error al eliminar un usuario, eliminar()");
            return "no se pudo eliminar ";
            // throw new SQLException();
        }
        return "se elimino con exito ";
    }

    public List<String[]> listar() throws SQLException {
        List<String[]> usuarios = new ArrayList<>();
        String query = "SELECT * FROM users";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            usuarios.add(new String[] {
                    String.valueOf(set.getInt("id")),
                    set.getString("name"),
                    set.getString("email"),
                    set.getString("password"),
                    String.valueOf(set.getInt("phone")),
                    set.getString("address"),

            });
        }
        return usuarios;
    }

    public String[] ver(int id) throws SQLException {
        String[] usuario = null;
        String query = "SELECT  * FROM users WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);

        ResultSet set = ps.executeQuery();
        if (set.next()) {
            usuario = new String[] {
                    String.valueOf(set.getInt("id")),
                    set.getString("name"),
                    set.getString("email"),
                    set.getString("password"),
                    String.valueOf(set.getInt("phone")),                    
                    set.getString("address"),

            };
        }
        return usuario;
    }

}