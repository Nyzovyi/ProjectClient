package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Street;
import ua.service.StreetService;

public class StreetEditor extends PropertyEditorSupport{

	private final StreetService streetService;

	public StreetEditor(StreetService streetService) {
		this.streetService = streetService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Street street = streetService.findOne(Integer.valueOf(text));
		setValue(street);
	}
}
