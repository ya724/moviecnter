package com.movie.web;

import com.movie.bean.Film;
import com.movie.service.FilmService;
import com.movie.untils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserFilmController {
    @Resource
    FilmService filmService;
    @RequestMapping({"/","/homeframework"})
    public String FilmFramework(Model model){
        List<Film> lastFilms = filmService.getLastFilms(4);
        //动作
        List<Film> filmsByFilmsCategory1 = filmService.getFilmsByFilmsCategory(1);
        //爱情
        List<Film> filmsByFilmsCategory2 = filmService.getFilmsByFilmsCategory(2);
        //谍战
        List<Film> filmsByFilmsCategory3 = filmService.getFilmsByFilmsCategory(3);
        model.addAttribute("filmsByFilmsCategory1",filmsByFilmsCategory1);
        model.addAttribute("filmsByFilmsCategory2",filmsByFilmsCategory2);
        model.addAttribute("filmsByFilmsCategory3",filmsByFilmsCategory3);
        model.addAttribute("lastFilms",lastFilms);
        return "user_home";
    }

    @RequestMapping("/filmPaging")
    public String FilmPaging(@RequestParam(value = "film_name",defaultValue = "") String film_name,
                             @RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                             Model model){
        Integer pageSize=8;
        Map<String,Object> map=new HashMap<>();
        map.put("film_name",film_name);
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        int allCount = filmService.getAllCount(map);

        List<Film> films = filmService.getFilms(map);
        PageUtil<Film> filmpage=new PageUtil<>(pageIndex,pageSize,allCount,films);

        model.addAttribute("filmPage",filmpage);

        model.addAttribute("film_name",film_name);
        return "user_list_film";
    }
}
