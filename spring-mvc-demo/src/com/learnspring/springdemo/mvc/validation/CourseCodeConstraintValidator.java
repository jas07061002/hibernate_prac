//package com.learnspring.springdemo.mvc.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class CourseCodeConstraintValidator implements
// ConstraintValidator<CourseCode, String>{
//	
//	
//	private String coursePrefix;
//	
//	public void initializer(CourseCode theCourseCode) {
//		coursePrefix = theCourseCode.value();
//		
//	}
//
//	@Override
//	public boolean isValid(String theCode, 
//			ConstraintValidatorContext theConstraintValidatorContext) {
//		
//		boolean result;
//		if(theCode != null) {
//			result= theCode.startsWith(coursePrefix);
//		}
//		else {
//			result = true;
//		}
//		return result;
//	}
//
//}
