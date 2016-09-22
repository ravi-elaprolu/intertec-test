package io.ravi.controller;

import io.ravi.domain.Username;
import io.ravi.services.Result;
import io.ravi.services.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    UsernameService usernameService;

    @Autowired
    private Validator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String formPost(ModelMap model, @RequestParam String name) {
        BindingResult validatorResult = validate(name);
        if (validatorResult.hasErrors()) {
            model.addAttribute("errors", validatorResult.getAllErrors());
        } else {
            Result<Boolean, List<String>> result = usernameService.checkUsernameAndSave(name);
            model.addAttribute("result", result);
        }

        List<Username> username = usernameService.findAll();
        model.addAttribute("usernames", username);

        return "index";
    }

    private BindingResult validate(@RequestParam String name) {
        Username username = new Username();
        username.setName(name);
        BindingResult validatorResult = new BeanPropertyBindingResult(username, "username");
        Set<ConstraintViolation<Username>> constraintViolations = validator.validate(username);
        for (ConstraintViolation<Username> constraintViolation : constraintViolations) {
            validatorResult.addError(new ObjectError(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));
        }
        return validatorResult;
    }


}
