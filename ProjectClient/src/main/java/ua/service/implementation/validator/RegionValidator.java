package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.entity.Region;
import ua.service.RegionService;

public class RegionValidator implements Validator{

	private final RegionService regionService;
	private final Pattern pattern = Pattern.compile("\\w+");//[0-9]+ патерн для цифер
	
	public RegionValidator(RegionService regionService) {
		this.regionService = regionService;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Region.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Region region = (Region) obj;
		Matcher matcher = pattern.matcher(region.getName());
		if(!matcher.matches()){
			errors.rejectValue("name", "Region name can't be empty");
		}
		if(regionService.findByName(region.getName())!=null){
			errors.rejectValue("name", "Region with this name already exists");
		}
	}
}
