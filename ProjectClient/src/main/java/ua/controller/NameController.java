package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Name;
import ua.service.NameService;

@Controller
public class NameController {

	@Autowired
	private NameService nameService;
	
	@ModelAttribute("name")
	public Name getName(){
		return new Name();
	}
	
	@RequestMapping("/admin/name")
	public String showName(Model model){
		model.addAttribute("names", nameService.findAll());
		return "adminName";
	}
	
	@RequestMapping("/admin/name/delete/{id}")
	public String deleteName(@PathVariable int id){
		nameService.delete(id);
		return "redirect:/admin/name";
	}
	
	@RequestMapping(value= "/admin/name", method=RequestMethod.POST)
	public String showName(@ModelAttribute("name") Name name){
		nameService.save(name);
		return "redirect:/admin/name";
	}
	
	@RequestMapping("/admin/name/update/{id}")
	public String updateName(@PathVariable int id, Model model){
		model.addAttribute("name", nameService.findOne(id));
		model.addAttribute("names", nameService.findAll());
		return "redirect:/admin/name";
	}
	
	

	
}
