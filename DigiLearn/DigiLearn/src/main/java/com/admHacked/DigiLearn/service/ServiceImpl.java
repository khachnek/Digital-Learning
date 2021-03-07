package com.admHacked.DigiLearn.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.admHacked.DigiLearn.dao.DAO;
import com.admHacked.DigiLearn.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

	@Autowired
	private DAO daoImpl;
	
	
	//Getting the course list from the database
	@Override
	public Map<String, String> getCourseList(String type) throws SQLException, IOException {
		return daoImpl.courseList(type);
	}
	
	//Getting the course list for specified interest from the whole list
	@Override
	public Map<String, String> getInterestsCourses(int id, String name) throws SQLException, IOException {
		Map<String, String> coursesList = new LinkedHashMap<String, String>();
		String[] EmpInterest = daoImpl.getEmployeeInterest(id, name);
		for (String s : EmpInterest) {
			Map<String, String> tempMap = daoImpl.courseList(s);
			coursesList.putAll(tempMap);
		}
		return coursesList;
	}
	
	//Getting the learning path for the specified project id
	@Override
	public Map<String, String> getLearningPath(int projectId) throws SQLException, IOException {
		Map<String, String> learningPath = new LinkedHashMap<String, String>();
		String[] requirements = daoImpl.getProjectRequirements(projectId);
		for (String s : requirements) {
			Map<String, String> tempMap = daoImpl.courseList(s);
			Map.Entry<String, String> entry = tempMap.entrySet().iterator().next();
			learningPath.putIfAbsent(entry.getKey(), entry.getValue());
		}
		return learningPath;
	}
	
	@Override
	public boolean doesEmployeeExist(int id,String name) throws SQLException, IOException {
		return daoImpl.doesEmployeeExist(id,name);
	}
	
	@Override
	public boolean doesProjectIdExists(int projectId) throws SQLException, IOException {
		return daoImpl.doesProjectIdExists(projectId);
	}

	@Override
	public void updateInterest(Employee e) throws SQLException, IOException {
		int id=e.getEmployeeID();
		String interests=e.getSkills();
		daoImpl.updateSkills(id, interests);
		
	}

}
