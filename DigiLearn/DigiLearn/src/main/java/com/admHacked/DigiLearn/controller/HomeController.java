package com.admHacked.DigiLearn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.admHacked.DigiLearn.model.Employee;
import com.admHacked.DigiLearn.service.Service;

@Controller
public class HomeController {

	@Autowired
	private Service serviceImpl;

	@RequestMapping(value = "/")
	public String mainPage() {
		return "home";
	}

	@RequestMapping(value = "home")
	public String goToHomePage() {
		return "home";
	}

	@RequestMapping(value = "searchCourse")
	public String searchCourse() {
		return "searchCourse";
	}

	@RequestMapping(value = "showCourses", method = RequestMethod.POST)
	public ModelAndView showCourses(@RequestParam("type") String type) throws SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		if (type.isEmpty()) {
			mv.setViewName("searchCourse");
			return mv;
		}
		Map<String, String> allCourses = serviceImpl.getCourseList(type);
		if (allCourses.isEmpty()) {
			mv.addObject("type", type);
			mv.setViewName("noCourses");
			return mv;
		}
		mv.addObject("course", allCourses);
		mv.addObject("type", type);
		mv.setViewName("showCourses");
		return mv;
	}

	@RequestMapping(value = "suggestedCourses")
	public String suggestedCourses() {
		return "suggestedCourses";
	}

	@RequestMapping(value = "showSuggestedCourses")
	public ModelAndView showSuggestedCourses(@RequestParam("id") int id, @RequestParam("name") String name)
			throws SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		if (!serviceImpl.doesEmployeeExist(id, name)) {
			mv.setViewName("suggestedCourses");
			return mv;
		}
		Map<String, String> allInterestCourses = serviceImpl.getInterestsCourses(id, name);
		mv.addObject("courses", allInterestCourses);
		mv.setViewName("showSuggestedCourses");
		return mv;
	}

	@RequestMapping("learningPath")
	public String learningPath() {
		return "learningPath";
	}

	@RequestMapping("showLearningPath")
	public ModelAndView showLearningPath(@RequestParam("projectId") Integer projectId)
			throws SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		if (projectId == null) {
			mv.setViewName("learningPath");
			return mv;
		} else if (!(serviceImpl.doesProjectIdExists(projectId))) {
			mv.setViewName("noProject");
			mv.addObject("projectId", projectId);
			return mv;
		}
		Map<String, String> learningPath = serviceImpl.getLearningPath(projectId);
		mv.addObject("learningPath", learningPath);
		mv.addObject("projectId", projectId);
		mv.setViewName("showLearningPath");
		return mv;
	}

	@RequestMapping("updateInterest")
	public String updateInterst() {
		return "updateInterest";
	}

	@RequestMapping("updateEmpInterest")
	public ModelAndView updateInterest(@ModelAttribute("e") Employee e) throws SQLException, IOException {
		ModelAndView mv = new ModelAndView();
		if (e.getEmployeeID() == 0 || e.getEmployeeName().isEmpty() || e.getSkills().isEmpty()) {
			mv.setViewName("updateInterest");
			return mv;
		}
		serviceImpl.updateInterest(e);
		mv.setViewName("home");
		return mv;
	}

}
