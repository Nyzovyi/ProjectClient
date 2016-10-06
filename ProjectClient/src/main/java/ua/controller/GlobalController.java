package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.entity.MyUser;
import ua.service.MyUserService;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private MyUserService myUserService;

	@ModelAttribute("authUser")
	public MyUser getMyUser(){
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		if(!"anonymousUser".equals(id)){
			return myUserService.findById(Integer.valueOf(id));
		}
		return null;
	}
}