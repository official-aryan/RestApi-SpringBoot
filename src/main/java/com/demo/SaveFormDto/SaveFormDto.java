package com.demo.SaveFormDto;

import java.util.List;

import com.demo.Entity.Form;

public class SaveFormDto {

	private List<Form> getResult;
	private String message;
	public List<Form> getGetResult() {
		return getResult;
	}
	public void setGetResult(List<Form> getResult) {
		this.getResult = getResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
