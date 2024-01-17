package com.demo.SaveFormDto;

import com.demo.Entity.Form;

public class UpdateFormDto 
{
	private Form save;
	private String message;
	public Form getSave() {
		return save;
	}
	public void setSave(Form save) {
		this.save = save;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
