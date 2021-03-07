package com.admHacked.DigiLearn.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public interface DAO {

	public void connect() throws SQLException, IOException;

	public Map<String, String> courseList(String type) throws SQLException, IOException;

	public boolean doesEmployeeExist(int id,String name) throws SQLException, IOException;

	public void updateSkills(int id, String interests) throws SQLException, IOException;

	public void addEmployee(String id, String name, String interests) throws SQLException, IOException;

	public String[] getProjectRequirements(int projectId) throws SQLException, IOException;

	public boolean doesProjectIdExists(int projectId) throws SQLException, IOException;

	public String[] getEmployeeInterest(int id, String name) throws SQLException, IOException;

}