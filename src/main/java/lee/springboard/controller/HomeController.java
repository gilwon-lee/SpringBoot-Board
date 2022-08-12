package lee.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //index 파일 설정
    @GetMapping("/")
    public String home(){
        return "home";
    }


}
