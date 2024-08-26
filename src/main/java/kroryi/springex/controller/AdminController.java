package kroryi.springex.controller;

import kroryi.springex.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        return "admin.index.page";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/admin/login/login";
    }

    @PostMapping("/login")
    public String login(Model model, String user_id, String user_pw) {
        log.info("login: {},{}", user_id, user_pw);


//        log.info(userService.getAll());
        return "redirect:/admin/";
    }


}
