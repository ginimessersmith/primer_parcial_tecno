package command;

import java.util.HashMap;
import java.util.Map;

public class CommandInterpreter {

    private static final Map<String, String[]> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("categories", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("orders", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("paymentMethods", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("pizzas", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("sizes", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("usuario", new String[]{"save", "update", "findOne", "findAll"});
        COMMANDS.put("states", new String[]{"save", "update", "findOne", "findAll"});
    }

    public static String interpret(String subject) {
        subject = subject.replaceAll("[^a-zA-Z0-9\\s\\(\\),]", "");
        // Recortar espacios en blanco innecesarios fuera de los paréntesis
        subject = subject.replaceAll("\\s+", " ").trim();

        System.out.println("Subject luego de formatear: " + subject);
        if (subject.equals("help")) {
            return getHelpMessage();
        }

        String pattern = "(\\w+)\\s+(\\w+)\\s*\\((.*)\\)";
        java.util.regex.Pattern regex = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher matcher = regex.matcher(subject);

        if (!matcher.matches()) {
            return "Comando no reconocido. Por favor, asegúrate de seguir la estructura: {caso_de_uso} comando (parametros)";
        }

        String useCase = matcher.group(1).trim();
        String command = matcher.group(2).trim();
        String params = matcher.group(3).trim();

        if (!COMMANDS.containsKey(useCase)) {
            return "Caso de uso '" + useCase + "' no reconocido. Usa 'HELP' para ver la lista de casos de uso y comandos.";
        }

        boolean commandExists = false;
        for (String validCommand : COMMANDS.get(useCase)) {
            if (validCommand.equals(command)) {
                commandExists = true;
                break;
            }
        }

        if (!commandExists) {
            return "Comando '" + command + "' no reconocido para el caso de uso '" + useCase + "'. Usa 'HELP' para ver la lista de comandos.";
        }
        
        //Empezar el switch
        switch (useCase.toLowerCase()) {
            case "categories":
                if(command.equals("save")){
                    return HandleCategories.save(params);
                }else if(command.equals("update")){
                    return HandleCategories.update(params);
                }
            case "orders":
                if(command.equals("save")){
                    System.out.println("PARAMS SAVE ORDERS");
                    System.out.println(params);
                    return HandleOrders.save(params);
                }else if (command.equals("update")) {
                    return HandleOrders.update(params);
                }else if (command.equals("findAll")) {
                    System.out.println("find all orders execute");
                    return HandleOrders.findAll();
                }
            case "sizes":
                return "handleOrders";
            case "states":
                return "handleOrders";
            case "usuarios":
                return "handleOrders";
            case "paymentMethods":
                if(command.equals("save")){
                    return HandlePaymentMethods.save(params);
                }else if(command.equals("update")){
                    return HandlePaymentMethods.update(params);
                }else if(command.equals("delete")){
                    return HandlePaymentMethods.delete(params);
                }else if(command.equals("findOne")){
                    return HandlePaymentMethods.findOne(params);
                }else if(command.equals("findAll")){
                    return HandlePaymentMethods.findAll();
                }
            case "pizzas":
                return "handleOrders";
            default:
                return "No se reconoce " + useCase + "como un caso de uso";
        }
    }

    private static String getHelpMessage() {
        StringBuilder helpMessage = new StringBuilder("Lista de casos de uso y comandos:\n\n");
        for (Map.Entry<String, String[]> entry : COMMANDS.entrySet()) {
            helpMessage.append(entry.getKey()).append(":\n");
            for (String command : entry.getValue()) {
                helpMessage.append("  - ").append(command).append("\n");
            }
            helpMessage.append("\n");
        }
        return helpMessage.toString();
    }
}
