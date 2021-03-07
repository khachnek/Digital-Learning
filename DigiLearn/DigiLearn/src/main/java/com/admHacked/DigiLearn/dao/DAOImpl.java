package com.admHacked.DigiLearn.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

@Component
public class DAOImpl implements DAO {

	@Autowired
	private DataSourceProperties db;

	private String driver;
	private String connectionUrl;
	private String userName;
	private String password;

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	// Connect to database
	@Override
	public void connect() throws SQLException, IOException {

		userName = db.getUsername();
		password = db.getPassword();
		driver = db.getDriverClassName();
		connectionUrl = db.getUrl();

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(connectionUrl, userName, password);
		statement = connection.createStatement();
	}

	// Get a course list for specified type from database
	@Override
	public Map<String, String> courseList(String type) throws SQLException, IOException {
		connect();
		Map<String, String> courseList = new LinkedHashMap<String, String>();
		String sql = "select * from course where CourseType ='" + type + "';";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			courseList.put(resultSet.getString("CourseName"), resultSet.getString("CourseLink"));
		}
		return courseList;
	}

	// Check if the employee with the specified id exists or not
	@Override
	public boolean doesEmployeeExist(int id, String name) throws SQLException, IOException {
		connect();
		String sql = "select * from employee where EmployeeID='" + id + "' and EmployeeName='" + name + "' ;";
		resultSet = statement.executeQuery(sql);
		return (resultSet.next());
	}

	// Update the skills of the employee using the id of the employee and specified interests
	@Override
	public void updateSkills(int id, String interests) throws SQLException, IOException {
		connect();
		String sql = "update employee set EmployeeSkills='" + interests + "' where EmployeeID='" + id + "';";
		statement.execute(sql);
	}

	// Add a new employee
	@Override
	public void addEmployee(String id, String name, String interests) throws SQLException, IOException {
		connect();
		String sql = "insert into employee values ('" + id + "','" + name + "','" + interests + "');";
		statement.execute(sql);
	}

	// To check if the project with specified id exists or not
	@Override
	public boolean doesProjectIdExists(int projectId) throws SQLException, IOException {
		connect();
		String sql = "select * from project where ProjectId='" + projectId + "';";
		resultSet = statement.executeQuery(sql);
		return (resultSet.next());

	}

	/// To get the requirements of the specified projectId
	@Override
	public String[] getProjectRequirements(int projectId) throws SQLException, IOException {
		connect();
		String[] req = null;
		String sql = "select ProjectRequirements from project where ProjectId='" + projectId + "';";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			req = resultSet.getString("ProjectRequirements").split(",");
		}
		return req;
	}
	
	//To get the interests of the employee using the employee id and name
	@Override
	public String[] getEmployeeInterest(int id, String name) throws SQLException, IOException {
		connect();
		String[] interest = null;
		String sql = "select EmployeeSkills from employee where EmployeeID='" + id + "' and EmployeeName='" + name
				+ "' ;";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			interest = resultSet.getString("EmployeeSkills").split(",");
		}
		return interest;
	}

}
