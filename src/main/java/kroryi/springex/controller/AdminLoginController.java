package kroryi.springex.controller;

import kroryi.springex.dto.UserDTO;
import kroryi.springex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/admin/login")
@RequiredArgsConstructor
public class AdminLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user-login")
    public String list(Model model) {
        log.info("user -> list controller");
//        model.addAttribute("userList", loginService.getAll());
        return "admin.userlogin.page";
    }

    /*@RequestMapping(value = "/user-login", method = RequestMethod.GET)
    public String registerget(Model model) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String today = LocalDate.now().format(formatter);
//        model.addAttribute("today", today);
        log.info("GETtodo -> register controller");

        return "redirect:/admin/login/user-login";
    }*/

    @RequestMapping(value = "/user-login", method = RequestMethod.POST)
    public String userlogin(UserDTO userDTO, RedirectAttributes redirectAttributes) {
        log.info("POSTtodo -> login controller");

        UserDTO dto = userService.getOne(userDTO.getUser_id());
        if (dto == null) {
            return "redirect:/admin/login/user-login";

        }else {
            if(dto.getUser_pw().equals(userDTO.getUser_pw())){
                return "redirect:/admin/";
            }else{
                return "redirect:/admin/login/user-login";
            }
        }

    }
}
