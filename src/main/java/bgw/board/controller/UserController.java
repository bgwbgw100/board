package bgw.board.controller;

import bgw.board.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class UserController {

    private final UserService userService;

    @PutMapping("login")
    public void putUser(@RequestBody Map<String,String> paramMap){
        userService.putUser(paramMap);
    }

    @PatchMapping("login")
    public void patchUser(){

    }

    @PostMapping(value = "login")
    public void login(){

    }



}
