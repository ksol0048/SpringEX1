package kroryi.springex.service;

import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    //TodoMapper insert 와 연결
    void register(TodoDTO dto);

    //    List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
