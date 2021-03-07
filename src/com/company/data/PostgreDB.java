package com.company.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to get connections with postgreSQL

public class PostgreDB implements IDB{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        final String connectionUrl = "jdbc:postgresql://localhost:5432/transfermarkt";
        final String user = "postgres";
        final String password = "postgres";

        try {
            // Here I load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(connectionUrl, user, password);

            return con;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
