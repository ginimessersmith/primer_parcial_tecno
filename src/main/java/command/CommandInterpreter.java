package command;

import java.util.HashMap;
import java.util.Map;

public class CommandInterpreter {

    private static final Map<String, String[]> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("categories", new String[]{"save", "update", "findone", "findall"});
        COMMANDS.put("orders", new String[]{"save", "update", "findone", "findall"});
        COMMANDS.put("paymentmethods", new String[]{"save", "update", "findone", "findall"});
        COMMANDS.put("pizzas", new String[]{"save", "update", "findone", "findall"});
        COMMANDS.put("sizes", new String[]{"save", "update", "findone", "findall"});
        COMMANDS.put("usuario", new String[]{"save", "update", "findone", "findall"});
    }

    public static String interpret(String subject) {
        subject = subject.toLowerCase().replaceAll("[^a-z0-9\\s\\(\\),]", "").trim();

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
        switch (useCase) {
            case "categories":
                if(command.equals("save")){
                    return HandleCategories.save(params);
                }else if(command.equals("update")){
                    return HandleCategories.update(params);
                }
            case "orders":
                return "handleOrders";
                //return handleOrders(command, params);
            default:
                return "No se reconoce " + useCase + "como un caso de uso";
        }
        //return "Caso de uso: " + useCase + ", Comando: " + command + ", Parámetros: " + params;
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
