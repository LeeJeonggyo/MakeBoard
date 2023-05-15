package com.ella.MakeBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/boardList")
    public String boardList(){
        return "boardList";
    }
}
