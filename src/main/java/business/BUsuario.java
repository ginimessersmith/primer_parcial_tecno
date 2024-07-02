package business;

import java.sql.SQLException;
import java.util.List;

import data.DUsuario;

public class BUsuario {
    private DUsuario dUsuario;

    public BUsuario(){
        this.dUsuario = new DUsuario();
    }

    public String guardar(String name, String email, String password, int phone, String address, String role) {
        try {
            return dUsuario.guardar(name, email, password, phone, address, role);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar el usuario: " + e.getMessage();
        }
    }

    public String modificar(int id, String name, String email, String password, int phone, String address) {
        try {
            return dUsuario.modificar(id, name, email, password, phone, address);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al modificar el usuario: " + e.getMessage();
        }
    }

    public String eliminar(int id) {
        try {
            return dUsuario.eliminar(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el usuario: " + e.getMessage();
        }
    }

    public List<String[]> listar() {
        try {
            return dUsuario.listar();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] ver(int id) {
        try {
            return dUsuario.ver(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
