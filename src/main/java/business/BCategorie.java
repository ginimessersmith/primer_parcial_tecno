package business;

import java.sql.SQLException;
import java.util.List;

import data.DCategorie;

public class BCategorie {
    private DCategorie dCategorie;

    public BCategorie() {
        this.dCategorie = new DCategorie();
    }

    
    public String save(String name) {
        try {
            return dCategorie.save(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar la categoría: " + e.getMessage();
        }
    }

    
    public String update(int id, String name) {
        try {
            return dCategorie.update(id, name);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al modificar la categoría: " + e.getMessage();
        }
    }

    
    public String delete(int id) {
        try {
            return dCategorie.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar la categoría: " + e.getMessage();
        }
    }

   
    public List<String[]> findAll() {
        try {
            return dCategorie.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

   
    public String[] findOne(int id) {
        try {
            return dCategorie.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

