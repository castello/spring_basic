package com.fastcampus.ch2;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class GlobalValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz != null;
	}

	@Override
	public void validate(Object target, Errors errors) { 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
	}
}

