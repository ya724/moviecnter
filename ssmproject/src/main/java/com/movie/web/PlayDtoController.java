package com.movie.web;

import com.movie.bean.Film;
import com.movie.bean.FilmCategory;
import com.movie.bean.Room;
import com.movie.bean.ScreenWriter;
import com.movie.dto.FilmDto;
import com.movie.dto.PlayDto;
import com.movie.service.*;
import com.movie.untils.CommonResult;
import com.movie.untils.PageUtil;
import org.omg.PortableInterceptor.INACTIVE;
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
public class PlayDtoController {

    @Resource
    PlayDtoService playDtoService;
    @Resource
    RoomService roomService;
    @Resource
    FilmCategoryService filmCategoryService;
    @Resource
    FilmService filmService;


    @RequestMapping("/playdto_paging")
    public String FilmDtoPaging(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "4") Integer pageSize,
                                Model model){
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        int allCount = playDtoService.getAllCount();
        List<PlayDto> pagePlayDdtos = playDtoService.getPagePlayDto(map);
        PageUtil<PlayDto> pageUtil=new PageUtil<>(pageIndex,pageSize,allCount,pagePlayDdtos);
        model.addAttribute("pageUtil",pageUtil);
        return "admin_play_film";
    }

    @ResponseBody
    @RequestMapping("/getplayrooms")
    public List<Room> getPlayRooms(){
        List<Room> allPlayRooms = roomService.getAllPlayRooms();
        return allPlayRooms;
    }

   @ResponseBody
    @RequestMapping("/getallfilmtype")
    public List<FilmCategory> getAllFilmCategory(){
       List<FilmCategory> allFilmCategorys = filmCategoryService.getAllFilmCategorys();
       return allFilmCategorys;
    }
    @ResponseBody
    @RequestMapping("/getallfilms")
    public List<Film> getFilmsByCategory(Integer category_id){

        List<Film> allFilms=filmService.getFilmsByFilmsCategory(category_id);
        return allFilms;
    }

    @ResponseBody
    @RequestMapping("/addplaydto")
    public CommonResult getAddPlayDto(PlayDto playDto){
        CommonResult commonResult;
       int i=playDtoService.addPlayDto(playDto);
        if(i>0){
            commonResult=new CommonResult(200,"添加成功");
        }
        else {
            commonResult=new CommonResult(500,"添加失败");
        }
        return commonResult;
    }
    @ResponseBody
    @RequestMapping("/playstatechange")
    public CommonResult changeState(Integer play_id,Integer is_delete){
        CommonResult commonResult;
        int i=playDtoService.updateState(play_id,is_delete);
        if(i>0){
            commonResult=new CommonResult(200,"状态转换成功");
        }
        else {
            commonResult=new CommonResult(500,"状态转换失败");
        }
        return commonResult;
    }



}
