package ua.rd.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.rd.domain.User;

import java.beans.PropertyEditorSupport;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerAdvice {

    @InitBinder
    public void userBinder(WebDataBinder binder){
        binder.registerCustomEditor(User.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                User user = new User("With binder " + text);
                setValue(user);
            }
        });
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exception(Model model, Exception ex){
        model.addAttribute("ex", ex.getMessage() + " annotation");
        return "errors";
    }
}
