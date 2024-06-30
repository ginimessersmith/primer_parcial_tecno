package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import PostgreSQL.databaseConnection;

public class DSizes {
    public databaseConnection connection;
    ConfigDB ConfigDb = new ConfigDB();

    public DSizes() {
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

    public String save(String name) throws SQLException {
        String query = "INSERT INTO sizes(name) VALUES(?)";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setString(1, name);

        if (ps.executeUpdate() == 0) {
            System.err.println("class DSizes.java dice:" + "ocurrio un error al insertar un tamaño");
            throw new SQLException();
        }
        return "Se inserto con exito";
    }

    public String update(int id, String name) throws SQLException {
        String query = "UPDATE sizes SET name=? WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(2, id);
        ps.setString(1, name);
        if (ps.executeUpdate() == 0) {
            System.err.println("class DSizes.java dice:" + "ocurrio un error al modificar un tamaño");
            return "error al actualizar";
        }
        return "se actualizo con exito";
    }

    public String delete(int id) throws SQLException {
        String query = "DELETE FROM sizes WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 0) {
            System.err.println("Class DSizes.java dice: "
                    + "Ocurrió un error al eliminar un usuario, delete()");
            return "no se pudo eliminar ";
        }
        return "se elimino con exito ";
    }

    public List<String[]> findAll() throws SQLException {
        List<String[]> sizes = new ArrayList<>();
        String query = "SELECT * FROM sizes";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            sizes.add(new String[] {
                    String.valueOf(set.getInt("id")),
                    set.getString("name")
            });
        }
        return sizes;
    }

    public String[] findOne(int id) throws SQLException {
        String[] size = null;
        String query = "SELECT * FROM sizes WHERE id=?";
        PreparedStatement ps = connection.connection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            size = new String[] {
                String.valueOf(set.getInt("id")),
                set.getString("name")
            };
        }
        return size;
    }

}