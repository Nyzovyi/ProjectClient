package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.entity.Adress;
import ua.form.AdressForm;
import ua.service.AdressService;

public class AdressValidator implements Validator{

	private final AdressService adressService;
	private final Pattern pattern = Pattern.compile("\\[0-9]+");//[0-9]+ патерн для цифер
	
	public AdressValidator(AdressService adressService) {
		this.adressService = adressService;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Adress.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		AdressForm adressForm = (AdressForm) obj;
		Matcher matcher = pattern.matcher(adressForm.getNamberHouse());
		if(!matcher.matches()){
			errors.rejectValue("namberHouse", "Adress namberHouse can't be empty");
		}
		if(adressService.findByNamberHouse(adressForm.getNamberHouse())!=null){
			errors.rejectValue("namberHouse", "Adress with this namberHouse already exists");
		}
	}
}
