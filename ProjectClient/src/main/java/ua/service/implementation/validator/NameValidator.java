package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.entity.Name;
import ua.service.NameService;

public class NameValidator implements Validator{

	private final NameService nameService;
	private final Pattern pattern = Pattern.compile("\\w+");//[0-9]+ патерн для цифер
	
	public NameValidator(NameService nameService) {
		this.nameService = nameService;
	}
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Name.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Name name = (Name) obj;
		Matcher matcher = pattern.matcher(name.getName());
		if(!matcher.matches()){
			errors.rejectValue("name", "Name name can't be empty");
		}
		if(nameService.findByName(name.getName())!=null){
			errors.rejectValue("name", "Name with this name already exists");
		}
	}
}
