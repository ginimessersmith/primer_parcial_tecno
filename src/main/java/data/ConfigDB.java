package data;

public class ConfigDB {
    private String user;
    private String password;
    private String host;
    private String port;
    private String dbName;

    // Constructor
    ConfigDB() {
        this.user = "postgres";
        this.password = "ginimessersmith123456";
        this.host = "127.0.0.1";
        this.port = "5432";
        this.dbName = "db_pizzeria";

    }

    // Getters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }
}
