package ua.rd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rd.domain.Tweet;
import ua.rd.domain.User;
import ua.rd.services.TweetService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    TweetService tweetService;

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        tweetService.deleteUser(getId(request));
        return "redirect:/users";
    }

    @GetMapping("/create")
    public String create(HttpServletRequest request, Model model) {
        model.addAttribute("user", new User());
        return "userEdit";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", tweetService.getUserById(getId(request)));
        return "userEdit";
    }


    private Long getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Long.valueOf(paramId);
    }

    @ModelAttribute
    public User produceUser() {
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextLong());
        System.out.println("produceUser");
        return user;
    }


}
