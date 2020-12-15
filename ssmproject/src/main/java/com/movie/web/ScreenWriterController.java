package com.movie.web;

import com.movie.bean.FilmCategory;
import com.movie.bean.ScreenWriter;
import com.movie.service.ScreenWriterService;
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
public class ScreenWriterController {
    
    @Resource
    ScreenWriterService screenWriterService;
    
    @RequestMapping("/screenwriter_paging")
    public String Paging(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        int totalCount = screenWriterService.totalCount();
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<ScreenWriter> screenwriters = screenWriterService.getScreenWriters(map);
        PageUtil<ScreenWriter> screenwriterPage=new PageUtil<>(pageIndex,pageSize,totalCount,screenwriters);
        model.addAttribute("screenwriterPage",screenwriterPage);
        return "admin_movie_screenwriters";
    }

    @ResponseBody
    @RequestMapping("/screenwriter_add")
    public CommonResult AddScreenWrite(ScreenWriter screenwriter){
        CommonResult commonResult;
        int i = screenWriterService.addScreenWriter(screenwriter);
        if(i>0){
            commonResult=new CommonResult(200,"添加成功");
        }
        else {
            commonResult=new CommonResult(500,"添加失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/screenwriter_delete")
    public CommonResult DeleteScreenWriter(int screenwriter_id){
        CommonResult commonResult;
        int i = screenWriterService.deleteScreenWriter(screenwriter_id);
        if(i>0){
            commonResult=new CommonResult(200,"删除成功");
        }
        else {
            commonResult=new CommonResult(500,"删除失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/screenwriter_toupdate")
    public ScreenWriter ToupdateScreenWriter(int screenwriter_id){
        ScreenWriter screenWriter = screenWriterService.getById(screenwriter_id);
        return screenWriter;
    }

    @ResponseBody
    @RequestMapping("/screenwriter_update")
    public CommonResult UpdateScreenWriter(ScreenWriter screenwriter) {
        CommonResult commonResult;
        int i = screenWriterService.updateScreenWriter(screenwriter);
        //   System.out.println(filmCategory);
        if (i > 0) {
            commonResult = new CommonResult(200, "更新成功");
        } else {
            commonResult = new CommonResult(500, "更新失败");
        }
        return commonResult;
    }
}
