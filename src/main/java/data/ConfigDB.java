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
        this.password = "235364";
        this.host = "localhost";
        this.port = "5432";
        this.dbName = "db_pizza";
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
