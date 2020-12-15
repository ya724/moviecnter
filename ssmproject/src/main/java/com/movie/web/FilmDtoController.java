package com.movie.web;


import com.movie.bean.Film;
import com.movie.bean.FilmCategory;
import com.movie.bean.Performer;
import com.movie.bean.ScreenWriter;
import com.movie.dto.FilmDto;
import com.movie.service.*;
import com.movie.untils.CommonResult;
import com.movie.untils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FilmDtoController {
    @Resource
    FilmDtoService filmDtoService;
    @Resource
    FilmCategoryService filmCategoryService;
    @Resource
    ScreenWriterService screenWriterService;
    @Resource
    PerformerService performerService;


    @RequestMapping("/filmdtopaging")
    public String FilmDtoPaging(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "4") Integer pageSize,
                                Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        int allCount = filmDtoService.getAllCount();
        List<FilmDto> films = filmDtoService.getFilms(map);
        PageUtil<FilmDto> pageUtil=new PageUtil<>(pageIndex,pageSize,allCount,films);
        model.addAttribute("pageUtil",pageUtil);
        return "admin_list_film";
    }

    @ResponseBody
    @RequestMapping("/getfilmcategorys")
    public List<FilmCategory> getFilmCategorys(){
        List<FilmCategory> allFilmCategorys = filmCategoryService.getAllFilmCategorys();
        return allFilmCategorys;
    }

    @ResponseBody
    @RequestMapping("/getallscreenwriters")
    public List<ScreenWriter> getAllScreenWriters(){
        List<ScreenWriter> allSWriters = screenWriterService.getAllSWriter();
        return allSWriters;
    }

    @ResponseBody
    @RequestMapping("/getallperformers")
    public List<Performer> getAllPerformers(){
        List<Performer> allPerformers = performerService.getAllPerformers();
        return allPerformers;
    }

    @ResponseBody
    @RequestMapping("/addfilmdto")
    public CommonResult AddFilmDto(FilmDto filmDto){
        CommonResult commonResult;
        int count = filmDtoService.addFilmDto(filmDto);
        if(count==4){
            commonResult=new CommonResult(200,"新增成功");
        }
        else {
            commonResult=new CommonResult(500,"新增失败");
        }
        return  commonResult;
    }

    @RequestMapping("/getfilmdtobyid")
    public String GetFilmDtoById(Integer film_id,Model model){
        FilmDto filmDto = filmDtoService.getFilmDtoById(film_id);
        model.addAttribute("filmDto",filmDto);
        return "user_film_detail";
    }

    @ResponseBody
    @RequestMapping("/filmstatechange")
    public CommonResult FilmStateChange(Integer film_id,Integer is_delete){

        CommonResult commonResult;
        int count = filmDtoService.updateFilmState(film_id,is_delete);
        if(count>0){
            commonResult=new CommonResult(200,"操作成功");
        }
        else {
            commonResult=new CommonResult(500,"操作失败");
        }
        return  commonResult;
    }
}
