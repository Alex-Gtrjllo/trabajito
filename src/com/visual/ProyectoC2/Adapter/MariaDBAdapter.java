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
		String connectionString = "jdbc:mysql://localhost:3306/tiendita?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
		String user = "fran";
		String password = "azulyoro";
		
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
