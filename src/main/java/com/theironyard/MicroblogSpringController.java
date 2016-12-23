package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dlocke on 12/22/16.
 */

@Controller //controller for processing requests

public class MicroblogSpringController {

    public static HashMap<String, User> users = new HashMap<>();
    public static ArrayList<Message> messages = new ArrayList<>();

    //get name(s) and message(s) from db
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";
    }

    //user input to login
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    //user input to logout
    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //user input to add a new message
    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(Model model, String userMessage) {
        Message m = new Message ((messages.size() + 1), userMessage);
        messages.add(m);
        return "redirect:/";
    }

    //user input to delete a message
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String messageDelete(Model model, int id) {
        messages.remove(messages.remove(id - 1));
        return "redirect:/";
    }

}//end class MicroblogSpringController