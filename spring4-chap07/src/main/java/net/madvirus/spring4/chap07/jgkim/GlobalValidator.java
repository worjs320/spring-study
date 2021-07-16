package net.madvirus.spring4.chap07.jgkim;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserTemplate.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserTemplate userTemplate = (UserTemplate) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "global.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "global.required");

        if(!userTemplate.getId().equals("") && !userTemplate.getId().equals("worjs320")) {
            errors.rejectValue("id","global.incorrect");
        }
    }
}
