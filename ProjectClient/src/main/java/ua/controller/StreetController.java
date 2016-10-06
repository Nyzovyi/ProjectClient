package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.City;
import ua.entity.Street;
import ua.service.CityService;
import ua.service.StreetService;
import ua.service.implementation.editor.CityEditor;

@Controller
public class StreetController {

	@Autowired
	private CityService cityService;
	@Autowired
	private StreetService streetService;
	
	@InitBinder("street")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(City.class, new CityEditor(cityService));
	}
	
	@ModelAttribute("street") 
	public Street getForm(){
		return new Street();
	}
	
	@RequestMapping("/admin/street")
	public String showStreet(Model model, @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("streets", streetService.findAll(pageable));
		model.addAttribute("citys", cityService.findAll());
		return "adminStreet";
	}
	

	@RequestMapping("/admin/street/delete/{id}")
	public String deleteStreet(@PathVariable int id){
		streetService.delete(id);
		return "redirect:/admin/street";
	}
	
	@RequestMapping("/admin/street/update/{id}")   
	public String updateStreet(@PathVariable int id, Model model,  @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("street", streetService.findOne(id));
		model.addAttribute("citys", cityService.findAll());
		return "adminStreet";
	}
	
	@RequestMapping(value= "/admin/street", method=RequestMethod.POST) 
	public String showStreet(@ModelAttribute("street") @Valid Street street, BindingResult br, Model model, @PageableDefault(size=5) Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("streets", streetService.findAll(pageable));
			return "adminStreet";
		}
		streetService.save(street);
		return "redirect:/admin/street";
	}
}
