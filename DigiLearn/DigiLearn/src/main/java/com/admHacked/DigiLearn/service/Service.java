package com.admHacked.DigiLearn.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.admHacked.DigiLearn.model.Employee;

public interface Service {

	public Map<String, String> getCourseList(String type) throws SQLException, IOException;

	public void updateInterest(Employee e) throws SQLException, IOException;

	public Map<String, String> getInterestsCourses(int id, String name) throws SQLException, IOException;

	public Map<String, String> getLearningPath(int projectId) throws SQLException, IOException;

	public boolean doesEmployeeExist(int id, String name) throws SQLException, IOException;

	public boolean doesProjectIdExists(int projectId) throws SQLException, IOException;
}