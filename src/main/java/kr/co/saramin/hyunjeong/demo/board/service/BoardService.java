package kr.co.saramin.hyunjeong.demo.board.service;

import kr.co.saramin.hyunjeong.demo.board.domain.BoardVo;
import kr.co.saramin.hyunjeong.demo.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("kr.co.saramin.hyunjeong.demo.board.service.BoardService")
public class BoardService {

    @Resource(name="kr.co.saramin.hyunjeong.demo.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;

    public List<BoardVo> boardListService() throws Exception {
        return mBoardMapper.boardList();
    }

    public BoardVo boardDetailService(int idx) throws Exception {
        return mBoardMapper.boardDetail(idx);
    }

    public int boardInsertService(BoardVo vo) throws Exception {
        return mBoardMapper.boardInsert(vo);
    }

    public int boardUpdateService(BoardVo vo) throws Exception {
        return mBoardMapper.boardUpdate(vo);
    }

    public int boardDeleteService(int idx) throws Exception {
        return mBoardMapper.boardDelete(idx);
    }
}
