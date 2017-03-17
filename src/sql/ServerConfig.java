/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author Mao
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerConfig {

    private String ServerName, Port, UserName, Password, DatabaseName;
    private Connection cn;
    private Properties connectionParameters;
    private final String fileServer = "config//config.properties";

    public String getDatabaseName() {
        return DatabaseName;
    }

    public void setDatabaseName(String DatabaseName) {
        this.DatabaseName = DatabaseName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getServerName() {
        return ServerName;
    }

    public void setServerName(String ServerName) {
        this.ServerName = ServerName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public ServerConfig() {
        this.ServerName = "";
        this.DatabaseName = "";
        this.UserName = "";
        this.Password = "";
        this.Port = "";
    }

    public ServerConfig(String ServerName, String DatabaseName, String UserName, String Password, String Port) {
        this.ServerName = ServerName;
        this.DatabaseName = DatabaseName;
        this.UserName = UserName;
        this.Password = Password;
        this.Port = Port;
    }

    public int setConnectParemeterFile() {
        connectionParameters = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileServer);
            connectionParameters.load(fis);
            ServerName = connectionParameters.getProperty("ServerName");
            DatabaseName = connectionParameters.getProperty("DatabaseName");
            UserName = connectionParameters.getProperty("UserName");
            Password = connectionParameters.getProperty("Password");
            Port = connectionParameters.getProperty("Port");
            fis.close();
            return 0;
        } catch (IOException ex) {
            System.out.println("Loi : " + ex.getMessage());
            return -1;
        }
    }

    public int openConnectionFromFile() {
        int loadFileStatus = setConnectParemeterFile();
        if (loadFileStatus == -1) {
            return -1;
        }
        if (loadFileStatus == 0) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://" + ServerName + ":" + Port + ";databasename=" + DatabaseName;
                cn = DriverManager.getConnection(url, UserName, Password);
            } catch (ClassNotFoundException e) {
                System.out.println("Loi : " + e.getMessage());

                return -1;
            } catch (SQLException e) {
                System.out.println("Loi : " + e.getMessage());

                return -1;
            }
        }
        return 0;
    }

    public void saveConnectionParametersToFile(String ServerName, String DatabaseName, String UserName, String Password, String Port) {
        connectionParameters = new Properties();
        FileOutputStream fsOut = null;
        try {
            fsOut = new FileOutputStream(fileServer);
            connectionParameters.setProperty("ServerName", ServerName);
            connectionParameters.setProperty("DatabaseName", DatabaseName);
            connectionParameters.setProperty("UserName", UserName);
            connectionParameters.setProperty("Password", Password);
            connectionParameters.setProperty("Port", Port);
            connectionParameters.store(fsOut, "");
            fsOut.close();
        } catch (IOException e) {
            System.out.println("Loi : " + e.getMessage());
        }
    }

    private void loadDriver() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    private void setConnectionParameters() throws SQLException {
        String url = "jdbc:sqlserver://" + ServerName + ":" + Port + ";databasename=" + DatabaseName;
        cn = DriverManager.getConnection(url, UserName, Password);
    }

    public int openConnection() {
        try {
            loadDriver();
            setConnectionParameters();
            return 0;
        } catch (ClassNotFoundException e) {
            System.out.println("Loi : " + e.getMessage());

            return -1;
        } catch (SQLException e) {
            System.out.println("Loi : " + e.getMessage());

            return -1;

        }
    }

    public void closeConnection(Connection temp) {
        try {
            temp.close();
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return cn;
    }
}
