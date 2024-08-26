package kroryi.springex.controller;

import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageUserRequestDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.dto.UserDTO;
import kroryi.springex.service.TodoService;
import kroryi.springex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class AdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/forgot")
    public String forgot(Model model) {
        log.info("user -> forgot controller");
//        model.addAttribute("userList", userService.getAll());
        return "admin.forgot.page";
    }

    @RequestMapping("/user-list")
    public String list(@Valid PageUserRequestDTO pageRequestDTO, Model model, BindingResult bindingResult) {
        log.info(pageRequestDTO);
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageUserRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", userService.getList(pageRequestDTO));
        model.addAttribute("pageRequestDTO", pageRequestDTO);

        return "admin.userlist.page";
    }

    public void list() {
        log.info("user -> list controller");
    }

    @RequestMapping({"/user-read"})
    public String read(String user_id, Model model, PageUserRequestDTO pageRequestDTO) {
        UserDTO userDTO = userService.getOne(user_id);
        log.info(userDTO);

        model.addAttribute("dto", userDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);

//        return "admin.todoread.page";
        return "admin.userread.page";
    }

    @RequestMapping(value = "/user-register", method = RequestMethod.GET)
    public String registerget(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter);
        model.addAttribute("today", today);
        log.info("GETtodo -> register controller");

        return "admin.userregister.page";
    }

    @RequestMapping(value = "/user-register", method = RequestMethod.POST)
    public String registerpost(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POSTtodo -> register controller");
        if (bindingResult.hasErrors()) {
            log.info("has errors ......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "/admin/user/user-register";
        }
        log.info(userDTO);
        userService.register(userDTO);

        return "admin.userlist.page";
    }




//위의 동일하지만 나눠서 진행
    //    @RequestMapping({"/read","modify"})
//    public String readOrModify(Long tno, Model model, HttpServletRequest req){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//        String reqURI = req.getRequestURI();
//        if(reqURI.contains("/modify")){
//            return "/todo/modify";
//        }else{
//            return "/todo/read";
//        }
//    }
//

    //    @RequestMapping("/read")
//    public void read(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }
//
//    @RequestMapping("/modify")
//    public void modify(Long tno, Model model){
//        TodoDTO todoDTO = todoService.getOne(tno);
//        model.addAttribute("dto", todoDTO);
//    }

    @RequestMapping({"/user-modify"})
    public String modify(String user_id, Model model, PageUserRequestDTO pageRequestDTO) {
        UserDTO userDTO = userService.getOne(user_id);
        log.info(userDTO);

        model.addAttribute("dto", userDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);

//        return "admin.todomodify.page";
        return "admin.usermodify.page";
    }

    @RequestMapping(value = "/user-modify", method = RequestMethod.POST)
    public String modify(PageUserRequestDTO pageRequestDTO, @Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POSTtodo -> modify controller");
        log.info("11111111111111111->{}", userDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors ......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", userDTO.getUser_id());
            return "redirect:/admin/user/user-modify?" + pageRequestDTO.getLink();
        }
//        log.info(userDTO);
        log.info(pageRequestDTO.getLink());

        userService.modify(userDTO);

        return "redirect:/admin/user/user-read?user_id="+userDTO.getUser_id()+"&"+ pageRequestDTO.getLink();

    }


    @RequestMapping(value = "/user-remove", method = RequestMethod.POST)
    public String remove(String user_id, RedirectAttributes redirectAttributes, PageUserRequestDTO pageRequestDTO) {
        log.info("POSTtodo -> remove controller");
        log.info("id:{}", user_id);

        userService.remove(user_id);

        return "redirect:/admin/user/user-list?" + pageRequestDTO.getLink();
    }
}
