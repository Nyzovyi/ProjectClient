package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.entity.Street;
import ua.service.StreetService;

public class StreetValidator implements Validator{

	private final StreetService streetService;
	private final Pattern pattern = Pattern.compile("\\w+");//[0-9]+ патерн для цифер
	
	public StreetValidator(StreetService streetService) {
		this.streetService = streetService;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Street.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Street street = (Street) obj;
		Matcher matcher = pattern.matcher(street.getName());
		if(!matcher.matches()){
			errors.rejectValue("name", "Street name can't be empty");
		}
		if(streetService.findByName(street.getName())!=null){
			errors.rejectValue("name", "Street with this name already exists");
		}
	}
}
