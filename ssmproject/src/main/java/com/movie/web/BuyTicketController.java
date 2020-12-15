package com.movie.web;

import com.movie.bean.Users;
import com.movie.dto.PlayDto;

import com.movie.service.BuyTicketService;
import com.movie.service.WeiXinService;
import com.movie.untils.CommonResult;
import com.movie.untils.IdWorker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BuyTicketController {

    @Resource
    BuyTicketService buyTicketService;

    @Resource
    WeiXinService weiXinService;

    @RequestMapping("/buyticket")
    public String buyTickets(Integer film_id, Model model){
        List<PlayDto> playDtos = buyTicketService.buyTicket(film_id);
        model.addAttribute("playdtos",playDtos);
        return "buyfilmtickets";

    }

    @ResponseBody
    @RequestMapping("/getplaysmsg")
    public  CommonResult getPlaysInfo(Integer play_id,Integer film_id){
        PlayDto playDto=null;
        List<PlayDto> playDtos=buyTicketService.buyTicket(film_id);
        for (PlayDto p:playDtos) {
            if(p.getPlay_id().toString().equals(play_id.toString())){
                playDto=p;
                break;
            }
        }
        return new CommonResult(200,"",playDto);
    }
    @ResponseBody
    @RequestMapping("/buy_findSelledSeatByPlayId")
    public   List<String> findSelledSeatByPlayId(Integer play_id){

        return  buyTicketService.getSelledSeatByPlayId(play_id);

    }

    /**
     * 跳转支付页面
     *
     * @param play_id
     * @param seats
     * @return
     */
    @RequestMapping(value = "/buy_toPay", method = RequestMethod.POST)
    public String toPay(Integer play_id, String seats, Model model,HttpSession session) {
      PlayDto  vo = buyTicketService.getPlayDtoById(play_id);

        session.setAttribute("seats",seats);
        StringBuffer stringBuffer = new StringBuffer();
        String[] arrays = seats.split(",");
        double money = vo.getMoney();
        double summoney=money*arrays.length;
        for (String s : arrays) {
            s = s.replace("-", "排") + "座";
            stringBuffer.append(s+" ");
        }
        model.addAttribute("seats", stringBuffer.toString());
        System.out.println(seats);
        model.addAttribute("vo", vo);
        model.addAttribute("summoney",summoney);

        IdWorker idWorker = new IdWorker();
        String orderId = String.valueOf(idWorker.nextId());
        Map<String, String> map = weiXinService.createNative(orderId, (int)(summoney*100)+"");
        String code_url = map.get("code_url");
        model.addAttribute("orderId",orderId);
        model.addAttribute("code_url",code_url);
        return "user_film_pay";
    }

    @ResponseBody
    @RequestMapping("/queryPayStatus")
    public CommonResult queryPayStatus(String out_trade_no, Integer play_id, HttpSession session) {
        CommonResult commonResult=null;
        String seats = (String) session.getAttribute("seats");
        Users loginUser = (Users) session.getAttribute("loginUser");

        int x=0;
        while (true){

            Map map = weiXinService.queryPayStatus(out_trade_no);

                if(map.get("trade_state").equals("SUCCESS")){
                    String[] seatNumbers = seats.split(",");
                    for (String seatName:seatNumbers) {
                     int seat_id=buyTicketService.getSeatIdBySeatName(seatName);
                     buyTicketService.addTicket(out_trade_no,play_id,loginUser.getUser_id(),seat_id);

                    }

                    commonResult=new CommonResult(200,"支付成功");
                  break;

                }
            try {
                Thread.sleep(3000);
                if(x>10){
                    commonResult=new CommonResult(300,"支付超时");
                    break;
                }
            } catch (InterruptedException e) {
                commonResult=new CommonResult(504,"支付异常");
                e.printStackTrace();
            }

            if(map==null||!map.get("trade_state").equals("SUCCESS")){
                commonResult=new CommonResult(555,"支付失败");
            }
        }

        return commonResult;
    }


}
