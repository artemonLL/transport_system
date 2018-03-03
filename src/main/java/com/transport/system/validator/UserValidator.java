package com.transport.system.validator;

import com.transport.system.model.User;
import com.transport.system.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator
{

    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user=(User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Required");
        if(user.getFirst_name().length()<6||user.getFirst_name().length()>32)
        {
            errors.rejectValue("suername","Size.uzerForm.username");
        }
        if(userService.getUserByName(user.getFirst_name())!=null)
        {
         errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required");
        if(user.getPassword().length()<6||user.getPassword().length()>32)
        {
            errors.rejectValue("password","Size.userForm.password");
        }
        if(!user.getConfirmPassword().equals(user.getPassword()))
        {
            errors.rejectValue("confirmPassword","Different.userForm.password");

        }





    }
}
