package bgw.board.service;

import bgw.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Map<String, Object>> getBoardList(){
        List<Map<String,Object>> data = boardMapper.selectBoardList();


    data.forEach(map ->{
            map.forEach((key,value) ->{
                log.info(key,value);
            });
        });
        return  data;
    };
    public void randomInsertBoard(){
        List<LocalDate> localDates = new ArrayList<>();

        for (int i = 0 ; i < 1000; i++){

        }
    }


    public LocalDate getRandomDate (int year, int mon ,int day){
        LocalDate startDate = LocalDate.of(2022, 1, 1); // 시작 날짜
        LocalDate endDate = LocalDate.now(); // 현재 날짜
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // 시작과 끝 날짜 사이의 일수를 계산
        Random random = new Random();
        long randomDays = random.nextLong( ) + daysBetween + 1; // 0부터 daysBetween까지 랜덤한 일수를 생성
        LocalDate randomDate = startDate.plusDays(randomDays); // 랜덤한 일수를 시작 날짜에 더하여 랜덤 날짜를 생성
        return randomDate;
    }
}
