package com.cotato.when2meet.promise.web;

import com.cotato.when2meet.promise.config.auth.LoginUser;
import com.cotato.when2meet.promise.config.auth.dto.SessionUser;
import com.cotato.when2meet.promise.service.PromiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PromiseService promiseService;
    private final HttpSession httpSession;


    // SessionUser user = (SessionUser) httpSession.getAttribute("user")
    // 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했다.
    // 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있따.
    // @LoginUser 어노테이션을 만들어서 코드 반복 개선
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("promise", promiseService.findAllDesc());

        // index.mustache에서 userName 사용할 수 있게 userName을 model에 저장함

        // 세션에 저장된 값이 있을 때만 model에 userName으로 등록한다.
        // 세션에 저장된 값이 없으면 model에 값이 없으므로 로그인 버튼이 보인다.
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/promise/save")
    public String promiseSave(){
        return "promise-save";
    }
}
