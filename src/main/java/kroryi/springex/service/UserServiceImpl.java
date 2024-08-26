package kroryi.springex.service;


import kroryi.springex.domain.UserVO;
import kroryi.springex.dto.UserDTO;
import kroryi.springex.dto.PageUserRequestDTO;
import kroryi.springex.dto.PageUserResponseDTO;
import kroryi.springex.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(UserDTO userDTO) {

        log.info("Register user: " + userDTO);
        UserVO userVO = modelMapper.map(userDTO, UserVO.class);
        log.info(userVO);

        userMapper.insert(userVO);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> dtoList = userMapper
                .selectAll()
                .stream()
                .map(vo -> modelMapper.map(vo, UserDTO.class))
                .collect(Collectors.toList());
        ;

        return dtoList;
    }

    @Override
    public PageUserResponseDTO<UserDTO> getList(PageUserRequestDTO pageRequestDTO) {
        List<UserVO> voList = userMapper.selectList(pageRequestDTO);
        List<UserDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, UserDTO.class))
                .collect(Collectors.toList());

        int total = userMapper.getCount(pageRequestDTO);

        PageUserResponseDTO<UserDTO> pageResponseDTO = PageUserResponseDTO.<UserDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public UserDTO getOne(String user_id) {
        UserVO userVO = userMapper.selectOne(user_id);

        if (userVO == null) {
            log.info(("Not found user: " + user_id));
            return null;
        }
        UserDTO userDTO = modelMapper.map(userVO, UserDTO.class);
        return userDTO;
    }

    @Override
    public void remove(String user_id) {
        userMapper.delete(user_id);
    }

    @Override
    public void modify(UserDTO userDTO) {
        UserVO userVO = modelMapper.map(userDTO, UserVO.class);

        userMapper.modify(userVO);
    }


}
