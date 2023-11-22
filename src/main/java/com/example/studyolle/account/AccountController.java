package com.example.studyolle.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    /*
    thymeleaf 라이브러리를 추가하면
    thymeleaf 자동으로 resources/templates 안에 폴더에서 model 파일을 찾는다.
    */

    @GetMapping("/sign-up")
    public String signUpForm(Model model){
        return "account/sign-up";
    }
}
