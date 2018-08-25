package com.bibo.springmvc.bankapp.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PSCodeStraintValidator implements ConstraintValidator{

	public String codePrefix;
	
	public void initialize(PSCode code) {
		codePrefix = code.value();
	}
	@Override
	public boolean isValid(Object code, ConstraintValidatorContext arg1) {

		boolean result;
		if(code!=null) {
		  result = ((String)code).startsWith(codePrefix);	
		}
		else
			result = true;
		return result;
	}


	
}
