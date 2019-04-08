package kr.co.saramin.hyunjeong.demo.board.controller;

import kr.co.saramin.hyunjeong.demo.board.domain.BoardVo;
import kr.co.saramin.hyunjeong.demo.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    @Resource(name="kr.co.saramin.hyunjeong.demo.board.service.BoardService")
    BoardService bs;

    @RequestMapping("/list")
    private String boardList(Model mo) throws Exception {
        mo.addAttribute("list", bs.boardListService());
        return "list";
    }

    @RequestMapping("/detail/{idx}")
    private String boardDetail(@PathVariable int idx, Model mo) throws Exception {
        mo.addAttribute("detail", bs.boardDetailService(idx));
        return "detail";
    }

    @RequestMapping("/insert")
    private String boardInsertForm() {
        return "insert";
    }

    @RequestMapping("/insertProc")
    private int boardInsertProc(HttpServletRequest rs) throws Exception {
        BoardVo bo = (BoardVo) rs.getParameterMap();
        return bs.boardInsertService(bo);
    }

    @RequestMapping("/update/{idx}")
    private String boardUpdateForm() {
        return "update";
    }

    @RequestMapping("/updateProc")
    private int boardUpdateProc(HttpServletRequest rs) throws Exception {
        BoardVo vo = (BoardVo) rs.getParameterMap();
        return bs.boardUpdateService(vo);
    }

    @RequestMapping("/delete/{idx}")
    private String boarderDelete(@PathVariable int idx) throws Exception {
        bs.boardDeleteService(idx);
        return "redirect:/list";
    }

}
