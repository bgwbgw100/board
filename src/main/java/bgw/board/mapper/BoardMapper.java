package bgw.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    List<Map<String,Object>> selectBoardList( Map<String,Object> dataMap);
}
