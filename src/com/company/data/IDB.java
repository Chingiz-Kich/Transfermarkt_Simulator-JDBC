package com.company.data;

import java.sql.*;

// Intefrace to get connection with postgreSQL

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
