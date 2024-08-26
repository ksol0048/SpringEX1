package kroryi.springex.service;

import kroryi.springex.dto.PageUserRequestDTO;
import kroryi.springex.dto.PageUserResponseDTO;
import kroryi.springex.dto.UserDTO;

import java.util.List;

public interface UserService {

    //TodoMapper insert 와 연결
    void register(UserDTO userDTO);

    List<UserDTO> getAll();

    PageUserResponseDTO<UserDTO> getList(PageUserRequestDTO pageRequestDTO);

    UserDTO getOne(String user_id);

    void remove(String user_id);

    void modify(UserDTO userDTO);
}
