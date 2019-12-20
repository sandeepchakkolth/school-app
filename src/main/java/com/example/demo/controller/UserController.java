package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

@Controller
public class UserController {

 @Autowired
 private UserService userService;
 
 @Autowired
 private StudentService studentService;
 
 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
 public ModelAndView login() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("user/login");
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
 public ModelAndView signup() {
  ModelAndView model = new ModelAndView();
  User user = new User();
  model.addObject("user", user);
  model.setViewName("user/signup");
  return model;
 }
 
 @RequestMapping(value= {"/home/student/addstudent"}, method=RequestMethod.GET)
 public ModelAndView addstudent() {
  ModelAndView model = new ModelAndView();
  Student student = new Student();
  model.addObject("student", student);
  model.setViewName("student/addstudent");
  
  return model;
 }
 
 @RequestMapping(value= {"/home/student/searchstudent"}, method=RequestMethod.GET)
 public ModelAndView searchstudent() {
  ModelAndView model = new ModelAndView();
  Student student = new Student();
  model.addObject("student", student);
  model.setViewName("student/searchstudent");
  
  return model;
 }
 
 @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
 public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  User userExists = userService.findUserByEmail(user.getEmail());
  
  if(userExists != null) {
   bindingResult.rejectValue("email", "error.user", "This email already exists!");
  }
  if(bindingResult.hasErrors()) {
   model.setViewName("user/signup");
  } else {
   userService.saveUser(user);
   model.addObject("msg", "User has been registered successfully!");
   model.addObject("user", new User());
   model.setViewName("user/signup");
  }
  
  return model;
 }
 
 @RequestMapping(value= {"/home/home"}, method=RequestMethod.GET)
 public ModelAndView home() {
  ModelAndView model = new ModelAndView();
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  User user = userService.findUserByEmail(auth.getName());
  
  model.addObject("userName", user.getFirstname() + " " + user.getLastname());
  model.setViewName("home/home");
  return model;
 }
 
 @RequestMapping(value= {"/home/student/addstudent"}, method=RequestMethod.POST)
 public ModelAndView createStudent(@Valid Student student, BindingResult bindingResult) {
  ModelAndView model = new ModelAndView();
  if(bindingResult.hasErrors()) {
   model.setViewName("student/addstudent");
  } else {
   studentService.saveStudentData(student);
   model.addObject("msg", "Student has been registered successfully!");
   model.addObject("student", new Student());
   model.setViewName("student/addstudent");
  }
  
  return model;
 }
 
 @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
 public ModelAndView accessDenied() {
  ModelAndView model = new ModelAndView();
  model.setViewName("errors/access_denied");
  return model;
 }
 
 @RequestMapping(value="/home/student/searchstudent/{name}", method=RequestMethod.GET)
 public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
     List<Student> list = null;
	try {
		list  = studentService.getStudentByName(name);
		
	} catch (RecordNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

     return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
 }
 
// @RequestMapping(value= "/home/student/searchstudent/{id}", method= RequestMethod.GET)
// public ResponseEntity<Student> getStudentById(@PathVariable long id) throws Exception {
//     System.out.println(" - Get student details by id is invoked.");
//
//     Student stu =  studentService.getStudentById(id);
//     if(!stu.isPresent())
//         throw new Exception("Could not find employee with id- " + id);
//
//     return new ResponseEntity<Student>(stu, new HttpHeaders(), HttpStatus.OK);
// }
}
