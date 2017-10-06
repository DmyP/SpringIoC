package ua.rd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rd.domain.User;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{name}")
    public String user(@PathVariable("name") User user, Model model) {
        model.addAttribute(user);
        return "user";
    }
    @GetMapping("/exception")
    public void error() {
        throw new IllegalArgumentException();
    }
}