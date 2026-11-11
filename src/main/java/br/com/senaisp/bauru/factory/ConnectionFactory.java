package br.com.senaisp.bauru.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//private static final String URL = "jdbc:mysql://localhost:3306/industria";
	private static final String URL = "jdbc:sqlite:database/pi.db";
    //private static final String USER = "root";
    //private static final String PASS = "";
    public static Connection conectar() throws SQLException {
    	//return DriverManager.getConnection( URL, USER, PASS);
        return DriverManager.getConnection( URL );
    }

}
