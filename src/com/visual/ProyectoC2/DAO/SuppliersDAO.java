package com.visual.ProyectoC2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.entitys.Suppliers;

public class SuppliersDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public SuppliersDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(Suppliers suppliers) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into suppliers values(?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, suppliers.getName());
				statement.setString(2, suppliers.getAddress());
				statement.setString(3, suppliers.getEmail());
				statement.setDouble(4, suppliers.getPhoneNumber());
				statement.setInt(5, suppliers.getProductID());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Suppliers getProduct(String name) {
		Suppliers suppliers = null; 
		if (connection != null) {
			String sql = "select * from supplier where name=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, name);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					suppliers = new Suppliers();
					suppliers.setName(results.getString(1));
					suppliers.setAddress(results.getString(2));
					suppliers.setEmail(results.getString(3));
					suppliers.setPhoneNumber(results.getInt(4));
					suppliers.setProductID(results.getInt(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return suppliers;
	}
	
	public List<Suppliers> getAllProducts() {
		List<Suppliers> suppliers = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from suppliers";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					String name = results.getString(1);
					String address = results.getString(2);
					String email = results.getString(3);
					int phoneNumber = results.getInt(4);
					int productID = results.getInt(5);
					Suppliers supplier = new Suppliers(name,address,email,phoneNumber,productID);
					suppliers.add(supplier);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return suppliers;
	}
	
	public boolean delete(String name) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from suppliers where name=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, name);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	
	public boolean update(Suppliers suppliers) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update product set "
					+ "name=?, address=?, email=?, "
					+ "phoneNumber=?, productID=? where name=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, suppliers.getName());
				statement.setString(2, suppliers.getAddress());
				statement.setString(3, suppliers.getEmail());
				statement.setInt(4, suppliers.getPhoneNumber());
				statement.setInt(5, suppliers.getProductID());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
		
	}
}
