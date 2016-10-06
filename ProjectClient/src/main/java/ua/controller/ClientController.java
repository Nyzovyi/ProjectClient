package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Adress;
import ua.form.ClientForm;
import ua.form.filter.ClientFilterForm;
import ua.service.AdressService;
import ua.service.CityService;
import ua.service.ClientService;
import ua.service.NameService;
import ua.service.StreetService;
import ua.service.implementation.editor.AdressEditor;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private NameService nameService;
	
	@Autowired
	private AdressService adressService;
	
	@Autowired
	private StreetService streetService;
	
	@Autowired
	private CityService cityService;
	
	
	@InitBinder("client")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Adress.class, new AdressEditor(adressService));
	}
	
	@ModelAttribute("client")
	public ClientForm getForm(){
		return new ClientForm();
	}
	
	@ModelAttribute("filter")
	public ClientFilterForm getFilter(){
		return new ClientFilterForm();
	}
	
	@RequestMapping("/admin/client")
	public String showClients(Model model, Pageable pageable){
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("names", nameService.findAll());
		model.addAttribute("adresss", adressService.findAll());
		model.addAttribute("streets", streetService.findAll());
		model.addAttribute("citys", cityService.findAll());
		return "adminClient";
	}
	
	@RequestMapping(value = "/admin/client", method=RequestMethod.POST)
	public String save(@ModelAttribute("form") ClientForm form,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ClientFilterForm filter){
		clientService.save(form);
		return "redirect:/admin/client";
	}
	
//	@RequestMapping(value="/admin/client", method=RequestMethod.POST)
//	public String save(@ModelAttribute("client") ClientForm form){
//		clientService.save(form);
//		return "redirect:/admin/client";
//	}
	
	@RequestMapping(value="/admin/client/delete/{id}")
	public String delete(@PathVariable int id){
		clientService.delete(id);
		return "redirect:/admin/client";
	}
	
	@RequestMapping(value="/admin/client/update/{id}")
	public String update(@PathVariable int id, Model model, Pageable pageable){
		model.addAttribute("client", clientService.findOneAdressInited(id));
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("adresss", adressService.findAll());
		return "adminClient";
	}
	
}