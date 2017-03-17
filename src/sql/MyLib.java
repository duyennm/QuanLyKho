/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;

public class MyLib {

    private static Properties connectionParameters;

    public static Connection getcn() {
        Connection cn = null;
        try {
            connectionParameters = new Properties();
            FileInputStream fis = null;
            fis = new FileInputStream("config//config.properties");
            connectionParameters.load(fis);
            String ServerName = connectionParameters.getProperty("ServerName");
            String DatabaseName = connectionParameters.getProperty("DatabaseName");
            String UserName = connectionParameters.getProperty("UserName");
            String Password = connectionParameters.getProperty("Password");
            String Port = connectionParameters.getProperty("Port");
            fis.close();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + ServerName + ":" + Port + ";databasename=" + DatabaseName;
            cn = DriverManager.getConnection(url, UserName, Password);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }

    public static Connection getcn(String hostname, String dbName, String user, String pass) {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + hostname + ";databasename=" + dbName;
            cn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }
}
