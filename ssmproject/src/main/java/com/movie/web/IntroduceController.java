package com.movie.web;

import com.movie.bean.Introduce;
import com.movie.service.IntroduceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IntroduceController {

    @Resource
    IntroduceService introduceService;
    @RequestMapping("/cinemaInfo")
    public String IntroduceInfo(Model model){
        List<Introduce> introduces = introduceService.getIntroduce();
        Introduce introduce=introduces.get(0);
        model.addAttribute("introduce",introduce);
        return "user_cinema_info";
    }
}
