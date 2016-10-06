package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.MyUser;
import ua.service.MyUserService;

@Controller
public class IndexController {

	@Autowired
	private MyUserService service;
	
	@RequestMapping("/")
	public String showIndex(MyUser myUser, Model model, Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
		}else{
			System.out.println("principal is null");
		}
		model.addAttribute("myUser", myUser);
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String showIndex(@ModelAttribute MyUser myUser){
		service.save(myUser);
		return "redirect:/";
	}
	@Secured(value="ROLE_ADMIN")
	@RequestMapping("/admin")
	public String showAdmin() {
		return "adminPanel";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
