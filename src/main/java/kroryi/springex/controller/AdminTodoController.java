package kroryi.springex.controller;

import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.service.TodoService;
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
@RequestMapping("/admin/todo")
@RequiredArgsConstructor
public class AdminTodoController {
    @Autowired
    private TodoService todoService;

    public void list() {
        log.info("todo -> list controller");
    }

    /*@RequestMapping("/list")
    public String list(Model model) {
        log.info("todo -> list controller");
        model.addAttribute("dtoList", todoService.getAll());

        return "todo/list";
    }*/

    @RequestMapping("/list")
    public String list(@Valid PageRequestDTO pageRequestDTO, Model model, BindingResult bindingResult) {
        log.info(pageRequestDTO);
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));

        return "admin.todolist.page";
    }

    @RequestMapping({"/read"})
    public String read(Long tno, Model model, PageRequestDTO pageRequestDTO) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);

        return "admin.todoread.page";
    }

    @RequestMapping({"/modify"})
    public String modify(Long tno, Model model, PageRequestDTO pageRequestDTO) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);

        return "admin.todomodify.page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerget(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter);
        model.addAttribute("today", today);
        log.info("GETtodo -> register controller");

        return "admin.todoregister.page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerpost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POSTtodo -> register controller");
        if (bindingResult.hasErrors()) {
            log.info("has errors ......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/admin/todo/register";
        }
        log.info(todoDTO);
        todoService.register(todoDTO);

        return "redirect:/admin/todo/list";
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
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(PageRequestDTO pageRequestDTO, @Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POSTtodo -> modify controller");
        log.info("11111111111111111->{}", todoDTO);

        if (bindingResult.hasErrors()) {
            log.info("has errors ......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/admin/todo/modify?" + pageRequestDTO.getLink();
        }
//        log.info(todoDTO);
        log.info(pageRequestDTO.getLink());

        todoService.modify(todoDTO);

        return "redirect:/admin/todo/read?tno="+todoDTO.getTno()+"&"+ pageRequestDTO.getLink();

    }


    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(Long tno, RedirectAttributes redirectAttributes, PageRequestDTO pageRequestDTO) {
        log.info("POSTtodo -> remove controller");
        log.info("tno:{}", tno);

        todoService.remove(tno);

        return "redirect:/admin/todo/list?" + pageRequestDTO.getLink();
    }
}
