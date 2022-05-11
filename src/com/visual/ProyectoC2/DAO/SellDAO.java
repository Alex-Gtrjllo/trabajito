package com.visual.ProyectoC2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.entitys.Sell;
import com.visual.ProyectoC2.entitys.User;

public class SellDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public SellDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(Sell sell) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into sells values(?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, sell.getSellID());
				statement.setTimestamp(2, sell.getFecha());
				statement.setInt(3, sell.getProductID());
				statement.setString(4, sell.getProductName());
				statement.setFloat(5, sell.getProductPrice());
				statement.setInt(6, sell.getStock());
				statement.setString(7, sell.getCodigo());
				statement.setInt(8, sell.getUserID());	
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Sell getProduct(int sellID) {
		Sell sell = null; 
		if (connection != null) {
			String sql = "select * from sells where sellID=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, sellID);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					sell = new Sell();
					sell.setSellID(results.getInt(1));
					sell.setFecha(results.getTimestamp(2));
					sell.setProductID(results.getInt(3));
					sell.setProductName(results.getString(4));
					sell.setProductPrice(results.getFloat(5));
					sell.setStock(results.getInt(6));
					sell.setCodigo(results.getString(7));
					sell.setUserID(results.getInt(8));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sell;
	}
	
	public List<Sell> getAllProducts() {
		List<Sell> sells = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from sells";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int sellID = results.getInt(1);
					Timestamp fecha = results.getTimestamp(2);
					int productID = results.getInt(3);
					String productName = results.getString(4);
					Float productPrice = results.getFloat(5);
					int stock = results.getInt(6);
					String codigo = results.getString(7);
					int userID = results.getInt(8);
					Sell sell = new Sell(sellID, fecha,productID, productName, productPrice, stock, codigo, userID);
					sells.add(sell);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sells;
	}
	
	public boolean delete(int sellID) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from sells where sellID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, sellID);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	
	public boolean update(Sell sell) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update sells set "
					+ "fecha=?, productID=?, productName=?, "
					+ "productPrice=?, stock=?, codigo=?, userID=? where sellID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setTimestamp(1, sell.getFecha());
				statement.setInt(2, sell.getProductID());
				statement.setString(3, sell.getProductName());
				statement.setFloat(4, sell.getProductPrice());
				statement.setInt(5, sell.getStock());
				statement.setString(6, sell.getCodigo());
				statement.setInt(7, sell.getUserID());
				statement.setInt(8, sell.getSellID());
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
