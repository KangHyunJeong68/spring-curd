package kr.co.saramin.hyunjeong.demo.board.mapper;

import kr.co.saramin.hyunjeong.demo.board.domain.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public int boardCount() throws Exception;

    public List<BoardVo> boardList() throws Exception;

    public BoardVo boardDetail(int idx) throws Exception;

    public int boardInsert(BoardVo board) throws Exception;

    public int boardUpdate(BoardVo board) throws Exception;

    public int boardDelete(int idx) throws Exception;
}
