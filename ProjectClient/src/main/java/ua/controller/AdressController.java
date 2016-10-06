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

import ua.entity.Adress;
import ua.entity.Street;
import ua.service.AdressService;
import ua.service.StreetService;
import ua.service.implementation.editor.StreetEditor;

@Controller
public class AdressController {

	@Autowired
	private AdressService adressService;
	@Autowired
	private StreetService streetService;
	
	@InitBinder("adress")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Street.class, new StreetEditor(streetService));
	}
	
	@ModelAttribute("adress") 
	public Adress getForm(){
		return new Adress();
	}
	
	@RequestMapping("/admin/adress")
	public String showAdress(Model model, @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("adresss", adressService.findAll(pageable));
		model.addAttribute("streets", streetService.findAll());
		return "adminAdress";
	}
	

	@RequestMapping("/admin/adress/delete/{id}")
	public String deleteAdress(@PathVariable int id){
		adressService.delete(id);
		return "redirect:/admin/adress";
	}
	
	@RequestMapping("/admin/adress/update/{id}")   
	public String updateAdress(@PathVariable int id, Model model,  @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("adress", adressService.findOne(id));
		model.addAttribute("streets", streetService.findAll());
		return "adminAdress";
	}
	
	@RequestMapping(value= "/admin/adress", method=RequestMethod.POST) 
	public String showAdress(@ModelAttribute("adress") @Valid Adress adress, BindingResult br, Model model, @PageableDefault(size=5) Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("adresss", adressService.findAll(pageable));
			return "adminAdress";
		}
		adressService.save(adress);
		return "redirect:/admin/adress";
	}
}
