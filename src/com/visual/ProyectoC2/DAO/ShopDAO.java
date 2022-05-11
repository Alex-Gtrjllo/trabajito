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
import com.visual.ProyectoC2.entitys.Shop;
import com.visual.ProyectoC2.entitys.User;

public class ShopDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public ShopDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(Shop shop) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into shopping values(?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, shop.getSellID());
				statement.setTimestamp(2, shop.getFecha());
				statement.setInt(3, shop.getProductID());
				statement.setString(4, shop.getProductName());
				statement.setFloat(5, shop.getProductPrice());
				statement.setInt(6, shop.getStock());
				statement.setString(7, shop.getCodigo());
				statement.setInt(8, shop.getUserID());	
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Shop getProduct(int sellID) {
		Shop shop = null; 
		if (connection != null) {
			String sql = "select * from shopping where sellID=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, sellID);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					shop = new Shop();
					shop.setSellID(results.getInt(1));
					shop.setFecha(results.getTimestamp(2));
					shop.setProductID(results.getInt(3));
					shop.setProductName(results.getString(4));
					shop.setProductPrice(results.getFloat(5));
					shop.setStock(results.getInt(6));
					shop.setCodigo(results.getString(7));
					shop.setUserID(results.getInt(8));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shop;
	}
	
	public List<Shop> getAllProducts() {
		List<Shop> shops = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from shopping";
			
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
					Shop shop = new Shop(sellID, fecha,productID, productName, productPrice, stock, codigo, userID);
					shops.add(shop);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return shops;
	}
	
	public boolean delete(int sellID) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from shopping where sellID=?";
			
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
	
	
	public boolean update(Shop shop) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update shopping set "
					+ "fecha=?, productID=?, productName=?, "
					+ "productPrice=?, stock=?, codigo=?, userID=? where sellID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setTimestamp(1, shop.getFecha());
				statement.setInt(2, shop.getProductID());
				statement.setString(3, shop.getProductName());
				statement.setFloat(4, shop.getProductPrice());
				statement.setInt(5, shop.getStock());
				statement.setString(6, shop.getCodigo());
				statement.setInt(7, shop.getUserID());
				statement.setInt(8, shop.getSellID());
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
