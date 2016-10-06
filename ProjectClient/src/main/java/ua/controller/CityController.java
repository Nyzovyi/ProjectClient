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
import ua.entity.Region;
import ua.service.CityService;
import ua.service.RegionService;
import ua.service.implementation.editor.RegionEditor;


	@Controller
	public class CityController {

		@Autowired
		private RegionService regionService;
		@Autowired
		private CityService cityService;
		
		@InitBinder("city")
		protected void initBinder(WebDataBinder binder){
			binder.registerCustomEditor(Region.class, new RegionEditor(regionService));
		}
		
		@ModelAttribute("city") 
		public City getForm(){
			return new City();
		}
		
		@RequestMapping("/admin/city")
		public String showCity(Model model, @PageableDefault(size=5) Pageable pageable){
			model.addAttribute("citys", cityService.findAll(pageable));
			model.addAttribute("regions", regionService.findAll());
			return "adminCity";
		}
		

		@RequestMapping("/admin/city/delete/{id}")
		public String deleteCity(@PathVariable int id){
			cityService.delete(id);
			return "redirect:/admin/city";
		}
		
		@RequestMapping("/admin/city/update/{id}")   
		public String updateCity(@PathVariable int id, Model model,  @PageableDefault(size=5) Pageable pageable){
			model.addAttribute("city", cityService.findOne(id));
			model.addAttribute("regions", regionService.findAll());
			return "adminCity";
		}
		
		@RequestMapping(value= "/admin/city", method=RequestMethod.POST) 
		public String showCity(@ModelAttribute("city") @Valid City city, BindingResult br, Model model, @PageableDefault(size=5) Pageable pageable){
			if(br.hasErrors()){
				model.addAttribute("citys", cityService.findAll(pageable));
				return "adminCity";
			}
			cityService.save(city);
			return "redirect:/admin/city";
		}
}

