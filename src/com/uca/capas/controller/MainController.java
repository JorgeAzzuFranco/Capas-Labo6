package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.daos.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}

		mav.addObject("students", students);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(String code) {
		ModelAndView mav = new ModelAndView();
		
		Integer Code = Integer.parseInt(code);
		
		Student st = new Student();
		try {
			st = studentDao.findOne(Code);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student", st);
		mav.setViewName("result");
		
		return mav;
	}
}
