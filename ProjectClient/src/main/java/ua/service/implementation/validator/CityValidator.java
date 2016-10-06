package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.entity.City;
import ua.service.CityService;

public class CityValidator implements Validator{

	private final CityService cityService;
	private final Pattern pattern = Pattern.compile("\\w+");//[0-9]+ патерн для цифер
	
	public CityValidator(CityService cityService) {
		this.cityService = cityService;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return City.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		City city = (City) obj;
		Matcher matcher = pattern.matcher(city.getName());
		if(!matcher.matches()){
			errors.rejectValue("name", "City name can't be empty");
		}
		if(cityService.findByName(city.getName())!=null){
			errors.rejectValue("name", "City with this name already exists");
		}
	}
}
