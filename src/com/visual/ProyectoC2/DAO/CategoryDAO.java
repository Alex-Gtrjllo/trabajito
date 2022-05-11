package com.visual.ProyectoC2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.entitys.Category;

public class CategoryDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public CategoryDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(Category category) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into category values(?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, category.getName());
				statement.setInt(2, category.getProductID());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public Category getCategory(int name) {
		Category category = null; 
		if (connection != null) {
			String sql = "select * from category where name=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, name);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					category = new Category();
					category.setName(results.getString(1));
					category.setProductID(results.getInt(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return category;
	}
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from category";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					String name = results.getString(1);
					int productID = results.getInt(2);
					Category category = new Category(name,productID);
					categories.add(category);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return categories;
	}
	
	public boolean delete(String name) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from category where name=?";
			
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
	
	
	public boolean update(Category category) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update category set "
					+ "name=?, productID=?, where name=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, category.getName());
				statement.setInt(2, category.getProductID());
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
