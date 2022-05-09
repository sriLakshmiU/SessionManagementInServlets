package DbConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.User;

public class UserDao {
	final DbConnection dbConnection = new DbConnection();
	 User user = new User();
	
	public int saveUser(User user) {
		String query = "insert into user(UserName,FirstName,LastName,Phone,Email) values(?,?,?,?,?)";
		PreparedStatement statement;
		int numberOfRecords =0;
		try {
			statement = dbConnection.getConnection().prepareStatement(query);
			statement.setString(1,user.getUserName());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setInt(4, user.getPhone());
			statement.setString(5, user.getEmail());
			numberOfRecords= statement.executeUpdate();
			System.out.println(numberOfRecords+" records updated.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numberOfRecords;
	}
	
	public User getUser(String userName) {
		User user = new User();
		String query = "Select * from user where UserName = '"+userName+"'";
		try {
			Statement statement = dbConnection.getConnection().createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				user.setUserName(result.getString("UserName"));
				user.setFirstName(result.getString("FirstName"));
				user.setLastName(result.getString("LastName"));
				user.setPhone(result.getInt("Phone"));
				user.setEmail(result.getString("Email"));
			}		
				user.setUserName(userName);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
