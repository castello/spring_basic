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
			// target이 User타입인 경우의 검증.
			if(target instanceof User) {
				User user = (User)target;

				String id = user.getId();
				
		//		if(id==null || "".equals(id.trim())) {
		//			errors.rejectValue("id", "required");
		//		}
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
				
				if(id==null || id.length() <  5 || id.length() > 12) {
					errors.rejectValue("id", "invalidLength");
				}				
			}
			
			// target이 다른 타입인 경우의 검증
			// ...
			
		} // validate()
	}

