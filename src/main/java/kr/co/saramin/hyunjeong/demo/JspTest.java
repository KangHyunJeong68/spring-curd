package kr.co.saramin.hyunjeong.demo;

import javax.annotation.Resource;

import kr.co.saramin.hyunjeong.demo.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspTest {

    @Autowired
    BoardMapper mBoardMapper;

    @RequestMapping("/test")
    private String jspTest() throws Exception{

        System.out.println(mBoardMapper.boardCount()); // <<<<TEST
        return "test";
    }
}

