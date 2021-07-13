package net.madvirus.spring4.chap07.jgkim;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserTemplate.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserTemplate userTemplate = (UserTemplate) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

        if(!userTemplate.getId().equals("") && !userTemplate.getId().equals("worjs320")) {
            errors.rejectValue("id","incorrect");
        }
    }
}
