package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Adress;
import ua.service.AdressService;

public class AdressEditor extends PropertyEditorSupport{

	private final AdressService adressService;

	public AdressEditor(AdressService adressService) {
		this.adressService = adressService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Adress adress = adressService.findOne(Integer.valueOf(text));
		setValue(adress);
	}
}
