package bgw.board.controller;

import bgw.board.dto.BoardDTO;
import bgw.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
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

    @GetMapping(value = "detail/{boardId}" )
    public String detail(@PathVariable("boardId") int boardId, ModelMap modelMap){
        BoardDTO boardDTO = boardService.detailBoard(boardId);
        modelMap.addAttribute("board",boardDTO);
        return "detail";
    }


}
