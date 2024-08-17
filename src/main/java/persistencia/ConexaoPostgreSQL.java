package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
    private String host;
    private String port;
    private String username;
    private String password;
    private String dbname;

    public ConexaoPostgreSQL() {
        this.host = "localhost";
        this.port = "5432";
        this.username = "postgres";
        this.password = "";
        this.dbname = "googlekeeptab";
    }

    public Connection getConexao() throws SQLException {
        String url = "jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.dbname;
        return DriverManager.getConnection(url, username, password);
    }

}
