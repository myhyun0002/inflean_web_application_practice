package com.example.studyolle.account;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class AccountController {

    /*
    thymeleaf 라이브러리를 추가하면
    thymeleaf 자동으로 resources/templates 안에 폴더에서 model 파일을 찾는다.
    */

    @GetMapping("/sign-up")
    public String signUpForm(Model model){
        model.addAttribute("signUpForm",new SignUpForm());
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public String SignUpSubmit(@Valid @ModelAttribute SignUpForm signUpForm, Errors errors){
        // SignUpForm에 정의한 nickname,email,password에 각각 정의된 annotation 규칙에 위배되면 error를 반환
        if(errors.hasErrors()) {
            return "account/sign-up";
        }

        // 회원 가입 처
        return "redirect:/";


    }
}
