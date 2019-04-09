package kr.co.saramin.hyunjeong.demo.board.controller;

import kr.co.saramin.hyunjeong.demo.board.domain.BoardVo;
import kr.co.saramin.hyunjeong.demo.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

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
    private String boardInsertProc(HttpServletRequest rs) throws Exception {
        BoardVo board = new BoardVo();
        board.setSubject(rs.getParameter("subject"));
        board.setContent(rs.getParameter("content"));
        board.setName(rs.getParameter("writer"));
        board.setPassword(rs.getParameter("password"));
        board.setIp(this.getLocalIp());
        bs.boardInsertService(board);
        return "redirect:/list";
    }

    @RequestMapping("/update/{idx}")
    private String boardUpdateForm(@PathVariable int idx, Model mo) throws Exception {
        mo.addAttribute("data", bs.boardDetailService(idx));
        return "update";
    }

    @RequestMapping("/updateProc")
    private String boardUpdateProc(HttpServletRequest rs) throws Exception {
        String pw = rs.getParameter("password");
        int idx = Integer.parseInt(rs.getParameter("idx"));
        BoardVo updateData = bs.boardDetailService((idx));
        String dbPw = updateData.getPassword();

        if (!dbPw.equals(pw)) {
            return "redirect:/update/" + idx;
        }

        BoardVo vo = new BoardVo();
        vo.setSubject(rs.getParameter("subject"));
        vo.setContent(rs.getParameter("content"));
        vo.setName(rs.getParameter("writer"));
        vo.setIp(this.getLocalIp());
        vo.setIdx(idx);
        int result = bs.boardUpdateService(vo);
        String type = result == 0 ? "update" : "detail";
        return "redirect:/" + type + "/" + idx;
    }

    @RequestMapping("/delete/{idx}")
    private String boarderDelete(@PathVariable int idx) throws Exception {
        bs.boardDeleteService(idx);
        return "redirect:/list";
    }

    private String getLocalIp() {
        InetAddress local;
        String ip = null;
        try {
            local = InetAddress.getLocalHost();
            ip = local.getHostAddress();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return ip;
    }
}
