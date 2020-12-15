package com.movie.web;

import com.movie.bean.Performer;
import com.movie.service.PerformerService;
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
public class PerformerController {
    @Resource
    PerformerService performerService;
    
    @RequestMapping("/performer_paging")
    public String Paging(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        int totalCount = performerService.totalCount();
        Map<String,Object> map=new HashMap<>();
        map.put("startPage",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Performer> performers = performerService.getPerformers(map);
        PageUtil<Performer> performerPage=new PageUtil<>(pageIndex,pageSize,totalCount,performers);
        model.addAttribute("performerPage",performerPage);
        return "admin_movie_performers";
    }

    @ResponseBody
    @RequestMapping("/performer_add")
    public CommonResult AddScreenWrite(Performer performer){
        CommonResult commonResult;
        int i = performerService.addPerformer(performer);
        if(i>0){
            commonResult=new CommonResult(200,"添加成功");
        }
        else {
            commonResult=new CommonResult(500,"添加失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/performer_delete")
    public CommonResult Deleteperformer(int performer_id){
        CommonResult commonResult;
        int i = performerService.deletePerformer(performer_id);
        if(i>0){
            commonResult=new CommonResult(200,"删除成功");
        }
        else {
            commonResult=new CommonResult(500,"删除失败");
        }
        return commonResult;
    }

    @ResponseBody
    @RequestMapping("/performer_toupdate")
    public Performer Toupdateperformer(int performer_id){
        Performer performer = performerService.getById(performer_id);
        return performer;
    }

    @ResponseBody
    @RequestMapping("/performer_update")
    public CommonResult Updateperformer(Performer performer) {
        CommonResult commonResult;
        int i = performerService.updatePerformer(performer);
        //   System.out.println(filmCategory);
        if (i > 0) {
            commonResult = new CommonResult(200, "更新成功");
        } else {
            commonResult = new CommonResult(500, "更新失败");
        }
        return commonResult;
    }
}
