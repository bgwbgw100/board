package bgw.board.service;

import bgw.board.dto.BoardDTO;
import bgw.board.mapper.BoardMapper;
import bgw.board.util.UtilMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Map<String, Object>> getBoardList(Map<String,Object> paramMap){
        UtilMap.getInstance().getPageParam(paramMap);


        List<Map<String,Object>> data = boardMapper.selectBoardList(paramMap);



        return  data;
    }

    public void postBoard(BoardDTO boardDTO){
        boardMapper.insertBoard(boardDTO);
    }

    public void randomInsertBoard(){
        for (int k = 0; k < 100; k++) {
            List<BoardDTO> boardDTOS = new ArrayList<>();
            for (int i = 0 ; i < 1000; i++){
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setId("bgwbgw100");
                boardDTO.setTitle("test데이터입니다");
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 100; j++) {
                    sb.append("test데이터입니다").append(j).append("\n");
                }
                boardDTO.setContent(sb.toString());
                boardDTO.setRegistDt(getRandomDate());
                boardDTO.setUpdateDt(getRandomDate());
                boardDTOS.add(boardDTO);
            }
            boardMapper.insertBoardBatch(boardDTOS);
        }


    }


    public LocalDate getRandomDate (){
        LocalDate startDate = LocalDate.of(2022, 1, 1); // 시작 날짜
        LocalDate endDate = LocalDate.now(); // 현재 날짜
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // 시작과 끝 날짜 사이의 일수를 계산
        Random random = new Random();
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween + 1); // 0부터 daysBetween까지 랜덤한 일수를 생성
        LocalDate randomDate = startDate.plusDays(randomDays); // 랜덤한 일수를 시작 날짜에 더하여 랜덤 날짜를 생성
        return randomDate;
    }

    public BoardDTO detailBoard(int boardId) {

        return boardMapper.selectBoardDetail(boardId);
    }
}
