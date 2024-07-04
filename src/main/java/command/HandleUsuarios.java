package command;

import java.util.List;

import business.BUsuario;

public class HandleUsuarios {

   
    public static String save(String params) {
        if (isValidFormat(params)) {
            try {
                String[] parts = params.split(", ");
                String name = parts[0];
                String email = parts[1];
                String password = parts[2];
                int phone = Integer.parseInt(parts[3]); // Convertir el string a entero
                String address = parts[4];
                String role = parts[5];

                BUsuario usuario = new BUsuario();
                return usuario.save(name, email, password, phone, address, role);
            } catch (NumberFormatException e) {
                return "HandleUsuarios.java dice: Ocurrió un error al convertir el teléfono, asegúrate de que es un número válido.";
            } catch (ArrayIndexOutOfBoundsException e) {
                return "HandleUsuarios.java dice: Ocurrió un error con el número de argumentos proporcionados.";
            }
        } else {
            return "HandleUsuarios.java dice: Ocurrió un error al ejecutar el método save "
                   + "(el parámetro no contiene los argumentos necesarios o está en formato incorrecto)";
        }
    }

   
    public static String update(String params) {
        if (!isValidFormat(params)) {
            return "Error: formato incorrecto o datos incompletos para actualizar.";
        }
        try {
            String[] parts = params.split(", ");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String email = parts[2];
            String password = parts[3];
            int phone = Integer.parseInt(parts[4]);
            String address = parts[5];
    
            BUsuario usuario = new BUsuario();
            return usuario.update(id, name, email, password, phone, address);
        } catch (NumberFormatException e) {
            return "Error: fallo al convertir el ID o teléfono a número.";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: ocurrió un error con el número de argumentos proporcionados.";
        }
    }

    
    public static String delete(String id) {
        try {
            int userId = Integer.parseInt(id); // Convertir el ID de String a int
            BUsuario usuario = new BUsuario();
            return usuario.delete(userId); // Llamar al método delete de BUsuario
        } catch (NumberFormatException e) {
            return "HandleUsuarios.java dice: El ID debe ser numérico y válido.";
        }
    }

    
    public static String findOne(String id) {
        try {
            int userId = Integer.parseInt(id);
            BUsuario usuario = new BUsuario();
            String[] userDetails = usuario.findOne(userId);
            if (userDetails == null || userDetails.length == 0) {
                return "No se encontró el usuario con ID: " + id;
            }
            return String.join(", ", userDetails);  // Concatenando la información del usuario
        } catch (NumberFormatException e) {
            return "Error: el ID debe ser numérico.";
        }
    }
    

 
     public static String findAll() {
        BUsuario usuario = new BUsuario();
        try {
            List<String[]> users = usuario.findAll();
            if (users.isEmpty()) {
                return "No hay usuarios registrados.";
            }
            StringBuilder sb = new StringBuilder();
            for (String[] user : users) {
                sb.append("Usuario: ");
                for (String detail : user) {
                    sb.append(detail).append(" ");
                }
                sb.append("\n"); // Añade una nueva línea entre usuarios
            }
            return sb.toString();
        } catch (Exception e) {
            return "Error al recuperar usuarios: " + e.getMessage();
        }
    }

    

    public static boolean isValidFormat(String input) {
        // Asume formato: ID, name, email, password, phone, address, role
        // Ejemplo: 1, Juan Perez, juanperez@example.com, pass123, 555666777, Calle 123, Admin
        String regex = "^\\d+, [a-zA-Z ]+, [a-zA-Z0-9@.]+, \\w+, \\d+, [a-zA-Z0-9 ]+, \\w+$";
        return input.matches(regex);
    }
}
