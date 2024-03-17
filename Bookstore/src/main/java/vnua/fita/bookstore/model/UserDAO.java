package vnua.fita.bookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vnua.fita.bookstore.bean.User;

public class UserDAO {
	public User checkLogin(String username, String password) {
		Connection connection = DBConnection.createConnection();
		String sql = "SELECT * FROM tbluser WHERE username=?and password=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return new User(resultSet.getString("username"), resultSet.getString("password"),
						resultSet.getString("fullname"), resultSet.getInt("role"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
