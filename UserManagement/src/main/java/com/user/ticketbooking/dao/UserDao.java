package com.user.ticketbooking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.ticketbooking.bean.User;

public class UserDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookings?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	
  //database query
	private static final String INSERT_USERS_SQL = "INSERT INTO bookings (email, eventName, ticketCount, ticketType) VALUES (?, ?, ?, ?)";
	private static final String SELECT_USER_BY_ID = "SELECT id, email, eventName, ticketCount, ticketType FROM bookings WHERE id = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM bookings";
	private static final String DELETE_USERS_SQL = "DELETE FROM bookings WHERE id = ?";
	private static final String UPDATE_USERS_SQL = "UPDATE bookings SET email = ?, eventName = ?, ticketCount = ?, ticketType = ? WHERE id = ?";

	public UserDao() {
	}
//make connection with database
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getEventName());
			preparedStatement.setInt(3, user.getTicketCount());
			preparedStatement.setString(4, user.getTicketType());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User selectUser(int id) {
		System.out.println("id: " + id);
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String email = rs.getString("email");
				String eventName = rs.getString("eventName");
				int ticketCount = rs.getInt("ticketCount");
				String ticketType = rs.getString("ticketType");
				user = new User(id, email, eventName, ticketCount, ticketType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String eventName = rs.getString("eventName");
				int ticketCount = rs.getInt("ticketCount");
				String ticketType = rs.getString("ticketType");
				users.add(new User(id, email, eventName, ticketCount, ticketType));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getEventName());
			statement.setInt(3, user.getTicketCount());
			statement.setString(4, user.getTicketType());
			statement.setInt(5, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
