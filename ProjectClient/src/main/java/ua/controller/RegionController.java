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

import ua.entity.Country;
import ua.entity.Region;
import ua.service.CountryService;
import ua.service.RegionService;
import ua.service.implementation.editor.CountryEditor;


@Controller
public class RegionController {

	@Autowired
	private RegionService regionService;
	@Autowired
	private CountryService countryService;
	
	@InitBinder("region") 
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
	}
	
	@ModelAttribute("region") 
	public Region getForm(){
		return new Region();
	}
	
	@RequestMapping("/admin/region")
	public String showRegion(Model model, @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("regions", regionService.findAll(pageable));
		model.addAttribute("countries", countryService.findAll());
		return "adminRegion";
	}
	

	@RequestMapping("/admin/region/delete/{id}")
	public String deleteRegion(@PathVariable int id){
		regionService.delete(id);
		return "redirect:/admin/region";
	}
	
	@RequestMapping("/admin/region/update/{id}")    
	public String updateRegion(@PathVariable int id, Model model,  @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("region", regionService.findOne(id));
		model.addAttribute("countries", countryService.findAll());
		return "adminRegion";
	}
	
	@RequestMapping(value= "/admin/region", method=RequestMethod.POST) 
	public String showRegion(@ModelAttribute("region") @Valid Region region, BindingResult br, Model model, @PageableDefault(size=5) Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("regions", regionService.findAll(pageable));
			return "adminRegion";
		}
		regionService.save(region);
		return "redirect:/admin/region";
	}
}
