package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.MyUser;
import ua.service.MyUserService;

@Controller
public class UserController {
	
	@Autowired
	private MyUserService userService;

	@ModelAttribute("myUser")
	public MyUser getForm(){
		return new MyUser();
	}
	
	@RequestMapping("/registration")
	public String register(){
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@ModelAttribute("myUser") MyUser myUser){
		userService.save(myUser);
		return "redirect:/login";
	}
}
