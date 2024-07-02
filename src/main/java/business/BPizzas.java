package business;

import java.sql.SQLException;
import java.util.List;

import data.DPizzas;

public class BPizzas {
    private DPizzas dPizzas;

    public BPizzas(){
        this.dPizzas = new DPizzas();
    }

    public String save(String name, Double price, String imagen_url, String description, Boolean available, int id_size, int id_category) {
        try {
            return dPizzas.save(name, price, imagen_url, description, available, id_size, id_category);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error saving pizza: " + e.getMessage();
        }
    }

    public String update(int id, String name, Double price, String imagen_url, String description, Boolean available, int id_size, int id_category) {
        try {
            return dPizzas.update(id, name, price, imagen_url, description, available, id_size, id_category);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating pizza: " + e.getMessage();
        }
    }

    public String delete(int id) {
        try {
            return dPizzas.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting pizza: " + e.getMessage();
        }
    }

    public List<String[]> findAll() {
        try {
            return dPizzas.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[] findOne(int id) {
        try {
            return dPizzas.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
