package com.premiumminds.webapp.wicket.bootstrap;

import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.premiumminds.webapp.wicket.bootstrap.datepicker.BootstrapDatePickerBehaviour;

public abstract class BootstrapDatepicker extends WebMarkupContainer {
	private static final long serialVersionUID = -117683073963817461L;

	private DateTextField dateField;
	
	public BootstrapDatepicker(String id) {
		super(id);
		add(new BootstrapDatePickerBehaviour() {
			private static final long serialVersionUID = 1L;

			@Override
			public Collection<SpecialDate> getSpecialDates() {
				return BootstrapDatepicker.this.getSpecialDates();
			}
		});
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		
		for(Component component : visitChildren(DateTextField.class)){
			dateField = (DateTextField) component;
			break;
		}
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		
		if(dateField!=null){
			tag.put("data-date-format", dateField.getTextFormat().toLowerCase());
		}
	}
	
	public Collection<SpecialDate> getSpecialDates() {
		return null;
	}
	
}
