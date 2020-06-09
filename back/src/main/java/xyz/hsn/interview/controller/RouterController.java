package xyz.hsn.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
    @GetMapping("/")
    public String index(){
        return "web";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
