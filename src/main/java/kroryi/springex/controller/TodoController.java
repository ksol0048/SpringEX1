package kroryi.springex.controller;

import kroryi.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {
    @RequestMapping("/list")
    public void list() {
        log.info("todo -> list controller");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("GETtodo -> register controller");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(TodoDTO todoDTO) {
        log.info("POSTtodo -> register controller");
        log.info(todoDTO);
    }
}
