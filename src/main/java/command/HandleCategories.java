package command;

import business.BCategorie;
                                            
public class HandleCategories {
    public static String save(String params){

        String response = "";

        if(params instanceof String){
            BCategorie categories = new BCategorie();
            response = categories.save(params);
        }else{
            response = "HandleCategories.java dice: Ocurrió un error al ejecutar el método save "
            + "(el parámetro contiene mas argumentos de los que necesita el método save)";
        }
        return response;
    }

    public static String update(String params){
        
        String response = "";
        if(isValidFormat(params)){
            String[] parts = params.split(", ");
            int id = Integer.parseInt(parts[0]);
            String categoryUpdate = parts[1];
            BCategorie categorie = new BCategorie();
            response = categorie.update(id, categoryUpdate);
            return response;
        }else{
            response = "HandleCategories.java dice: Ocurrió un error al ejecutar el método update "
            + "(los parámetros recibidos no cumplen con el formato que necesita el método save)";
            return response;
        }
    }

    public static boolean isValidFormat(String input) {
        String regex = "^\\d+, [a-zA-Z]+$";
        return input.matches(regex);
    }
}

