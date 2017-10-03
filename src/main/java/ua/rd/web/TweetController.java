package ua.rd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.rd.AuthorizedUser;
import ua.rd.domain.Tweet;
import ua.rd.repository.TweetRepository;
import ua.rd.services.TweetService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TweetController {

    @Autowired
    private TweetService tweetService;


    @RequestMapping("/")
    public String welcome() {
        System.out.println("[LOGGER] TweetController:welcome()");
        return "index";
    }


    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", tweetService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String setUser(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("userId"));
        AuthorizedUser.setId(userId);
        return "redirect:tweets";
    }

    @GetMapping("/tweets")
    public String tweets(Model model) {
        model.addAttribute("tweets", tweetService.getAllTweets());
        model.addAttribute("users", tweetService.getAllUsers());
        model.addAttribute("currentUser", AuthorizedUser.getId());
        return "tweets";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("[LOGGER] TweetController:hello()");
        return "hello";
    }

    @GetMapping("/tweet")
    public String tweet(Model model) {
        System.out.println("[LOGGER] TweetController:tweet()");
        Tweet tweet = tweetService.newTweet(null, "Some text");
        model.addAttribute(tweet);
        return "tweet";
    }

    @PostMapping("/tweetList")
    public String tweetList(Model model) {
        System.out.println("[LOGGER] TweetController::tweetList()");
        model.addAttribute("tweetList", tweetService.getAllTweets());
        return "tweet";
    }

    @PostMapping("/newtweet")
    public String newtweet(@RequestParam("tweetText") String tweetText, Model model) {
        System.out.println("[LOGGER] TweetController::newtweet()");
        System.out.println("[LOGGER] " + tweetText);

        Tweet tweet = tweetService.newTweet(null, tweetText);
        model.addAttribute("newtweet", tweet);
        return "tweet";
    }

    @GetMapping("/editTweet")
    public String editTweet(@RequestParam("id") int id, Model model) {
        System.out.println("[LOGGER] TweetController:editTweet()");
        Tweet tweet = tweetService.newTweet(null, "Some text");

        model.addAttribute(tweet);
        return "tweet";
    }
}