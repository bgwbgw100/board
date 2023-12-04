package bgw.board.controller;

import bgw.board.dto.BoardDTO;
import bgw.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String getBoar(){
        return "board";
    }

    @GetMapping("write")
    public String write(){

        return "write";
    }

    @PostMapping("write")
    public String postBoard(@Valid @ModelAttribute BoardDTO boardDTO){

        boardService.postBoard(boardDTO);

        return "redirect:/board";
    }


}
