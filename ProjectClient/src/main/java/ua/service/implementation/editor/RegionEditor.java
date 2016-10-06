package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Region;
import ua.service.RegionService;

public class RegionEditor extends PropertyEditorSupport{

	private final RegionService regionService;

	public RegionEditor(RegionService regionService) {
		this.regionService = regionService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Region region = regionService.findOne(Integer.valueOf(text));
		setValue(region);
	}
}
