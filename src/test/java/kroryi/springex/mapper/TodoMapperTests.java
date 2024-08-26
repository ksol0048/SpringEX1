package kroryi.springex.mapper;

import kroryi.springex.domain.TodoVO;
import kroryi.springex.domain.UserVO;
import kroryi.springex.dto.PageRequestDTO;
import kroryi.springex.dto.PageResponseDTO;
import kroryi.springex.dto.TodoDTO;
import kroryi.springex.mapper.TimeMapper;
import kroryi.springex.mapper.TimeMapper2;
import kroryi.springex.service.TodoService;
import kroryi.springex.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/tiles/tiles.xml"
})
public class TodoMapperTests {

    @Autowired(required = false)
    private TimeMapper mapper;

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;
    @Autowired
    private TodoMapper todoMapper;
    @Autowired
    private TodoService todoService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testGetTime(){
        log.info(mapper.getTime());
    }

    @Test
    public void testNow(){
        log.info(timeMapper2.getNow());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2024,8,29))
                .writer("이순신")
                .finished(false)
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    public void testRegister(){
        TodoDTO todoDTO= TodoDTO.builder()
                .title("테스트 입니다.")
                .dueDate(LocalDate.now())
                .writer("김갑수")
                .finished(true)
                .build();

        todoService.register(todoDTO);
    }

   /* @Test
    public void testSelectAll(){
        List<TodoVO> voList=todoMapper.selectAll();
        voList.forEach(vo->log.info(vo));
    }*/


   /* @Test
    public void testSelectOne(){
        TodoVO todoVO=todoMapper.selectOne(9L);
        log.info(todoVO);
    }*/

    @Test
    public void testSelectSearch(){
        PageRequestDTO pageRequestDTO= PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("테스트")
                .from(LocalDate.of(2024,8,29))
                .to(LocalDate.of(2024,8,29))
                .build();

        List<TodoVO> voList =todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo->log.info(vo));

        log.info(todoMapper.getCount(pageRequestDTO));
    }
/* @Test
    public void testSelectOne(){
        UserVO vo= (UserVO) userService.getAll();
        log.info(vo);
    }*/

}
