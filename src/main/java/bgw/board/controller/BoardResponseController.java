package bgw.board.controller;

import bgw.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardResponseController {

    private final BoardService boardService;

    @GetMapping("list")
    public List<Map<String, Object>>  test( @RequestParam Map<String,Object> paramMap){

        return boardService.getBoardList(paramMap);
    }


    @PutMapping("board")
    public void putBoard(){

    }
    @DeleteMapping("board")
    public void deleteBoard(){

    }
    @PatchMapping("board")
    public void patchBoard(){

    }

}
