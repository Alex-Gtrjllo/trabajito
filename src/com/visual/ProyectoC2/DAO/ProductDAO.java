package com.visual.ProyectoC2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.entitys.Product;

public class ProductDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public ProductDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(Product product) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into product values(?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, product.getProductID());
				statement.setString(2, product.getName());
				statement.setFloat(3, product.getPrice());
				statement.setInt(4, product.getStock());
				statement.setString(5, product.getCodigo());
				statement.setInt(6, product.getUserID());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Product getProduct(int productID) {
		Product product = null; 
		if (connection != null) {
			String sql = "select * from product where productID=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, productID);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					product = new Product();
					product.setProductID(results.getInt(1));
					product.setName(results.getString(2));
					product.setPrice(results.getFloat(3));
					product.setStock(results.getInt(4));
					product.setCodigo(results.getString(5));
					product.setUserID(results.getInt(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return product;
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from product";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int productID = results.getInt(1);
					String name = results.getString(2);
					Float price = results.getFloat(3);
					int stock = results.getInt(4);
					String codigo = results.getString(5);
					int userID = results.getInt(6);
					Product product = new Product(productID,name,price,stock,codigo,userID);
					products.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}
	
	public boolean delete(int productID) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from product where productID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, productID);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	
	public boolean update(Product product) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update product set "
					+ "name=?, price=?, "
					+ "stock=?, codigo=?, userID=? where productID=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);				
				statement.setString(1, product.getName());
				statement.setFloat(2, product.getPrice());
				statement.setInt(3, product.getStock());
				statement.setString(4, product.getCodigo());
				statement.setInt(5, product.getUserID());
				statement.setInt(6, product.getProductID());
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
