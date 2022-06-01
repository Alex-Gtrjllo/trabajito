package com.visual.ProyectoC2.Adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBAdapter {
	
	private static MariaDBAdapter instancia = null;
	private static Connection connection = null;
	
	public static MariaDBAdapter getInstancia() {
		if (instancia == null) {
			instancia = new MariaDBAdapter();
			instancia.Connection();
		}
		return instancia;
	}
	
	public void Connection() {
		String connectionString = "jdbc:mariadb://localhost:3306/tiendita?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
		String user = "root";
		String password = "alexito2012";
		
		try {
			connection = DriverManager.getConnection(connectionString, user, password);
			System.out.println(connection.getClass().getCanonicalName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	

}
