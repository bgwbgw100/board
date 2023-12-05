package bgw.board.mapper;

import bgw.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String,Object>> selectBoardList( Map<String,Object> dataMap);

    void insertBoard(BoardDTO boardDTO);

    void insertBoardBatch(List<BoardDTO> boardDTOS);


}
