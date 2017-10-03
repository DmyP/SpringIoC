package ua.rd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rd.services.TweetService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    TweetService tweetService;

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        tweetService.getUserById(getId(request));
        return "redirect:/users";
    }


    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", tweetService.getUserById(getId(request)));
        return "user";
    }


    private Long getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Long.valueOf(paramId);
    }


}
