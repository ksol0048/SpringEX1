package kroryi.springex.mapper;

import kroryi.springex.domain.UserVO;
import kroryi.springex.dto.PageUserRequestDTO;

import java.util.List;

public interface UserMapper {

    void insert(UserVO userVO);

    List<UserVO> selectAll();

    UserVO selectOne(String user_id);

    void delete(String user_id);

    void modify(UserVO userVO);

    List<UserVO> selectList(PageUserRequestDTO pageRequestDTO);

    int getCount(PageUserRequestDTO pageRequestDTO);
}
