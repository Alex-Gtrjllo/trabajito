package com.visual.ProyectoC2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.entitys.User;


public class UserDAO {
	private Connection connection = null;
	private final int ACCEPT = 1;
	
	public UserDAO() {
		MariaDBAdapter conector = MariaDBAdapter.getInstancia();
		connection = conector.getConnection();
	}
	
	public boolean insert(User user) {
		boolean resultado = false;
		if (connection != null) {
			String sql = "insert into user values(?,?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, user.getIdUser());
				statement.setString(2, user.getNombre());
				statement.setString(3, user.getApellidoPaterno());
				statement.setString(4, user.getApellidoMaterno());
				statement.setString(5, user.getLogin());
				statement.setString(6, user.getPassword());
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public User getUser(int idUser) {
		User user = null; 
		if (connection != null) {
			String sql = "select * from user where idUser=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idUser);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					user = new User();
					user.setIdUser(results.getInt(1));
					user.setNombre(results.getString(2));
					user.setApellidoPaterno(results.getString(3));
					user.setApellidoMaterno(results.getString(4));
					user.setLogin(results.getString(5));
					user.setPassword(results.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public User getUser(String login) {
		User user = new User();
		if (connection != null) {
			String sql = "select * from user where login=?";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, login);
				ResultSet results = statement.executeQuery();
				results.next();
				if (results.getRow() == ACCEPT) {
					user.setIdUser(results.getInt(1));
					user.setNombre(results.getString(2));
					user.setApellidoPaterno(results.getString(3));
					user.setApellidoMaterno(results.getString(4));
					user.setLogin(results.getString(5));
					user.setPassword(results.getString(6));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return user;
			
	}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		
		if (connection != null) {
			String sql = "select * from user";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {
					int idUser = results.getInt(1);
					String nombre = results.getString(2);
					String apellidoPaterno = results.getString(3);
					String apellidoMaterno = results.getString(4);
					String login = results.getString(5);
					String password = results.getString(6);
					User user = new User(idUser,nombre,apellidoPaterno,apellidoMaterno,login,password);
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public boolean delete(int idUser) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from user where idUser=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, idUser);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public boolean delete(String login) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "delete from user where nombre=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, login);
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public boolean update(User user) {
		boolean resultado = false;
		
		if (connection != null) {
			String sql = "update user set "
					+ "nombre=?, apellidoPaterno=?, apellidoMaterno=?, "
					+ "login=?, password=? where idUser=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, user.getNombre());
				statement.setString(2, user.getApellidoPaterno());
				statement.setString(3, user.getApellidoMaterno());
				statement.setString(4, user.getLogin());
				statement.setString(5, user.getPassword());
				statement.setInt(6, user.getIdUser());
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
