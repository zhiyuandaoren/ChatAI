package com.example.mailregister.controller;

import com.example.mailregister.service.userService2;
import com.example.mailregister.util.AlipayUtil;
import com.example.mailregister.entity.dto.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AlipayController {

    private AlipayUtil alipayUtil;
    String VipId;
    String Price;
    String VipType;

    @Autowired
    public void setAlipayUtil(AlipayUtil alipayUtil) {
        this.alipayUtil = alipayUtil;
    }

    @Autowired
    private userService2 userService2;


    @GetMapping("/")
    public String show(){
        return "index2";
    }


    //前端数据写入数据库，同时赋值给id、price、title提供给支付宝接口
    @PostMapping("/users")
    public String create1(@RequestBody userDto userDto){
        VipId= userDto.getVipid();
        VipType = userDto.getViptype();
        Price = userDto.getPrice();
        System.out.println(userDto.getVipid()+userDto.getViptype()+userDto.getPrice()+userDto.getEmail()+userDto.getStart()+userDto.getEnd());
        userService2.createUser(userDto);
        return "index2";
    }

    //通过全局变量将数据传入支付宝接口
    @PostMapping("/create")
    public String create(Model model){
        String pay = alipayUtil.pay(VipId, Price, VipType);
        System.out.println("支付宝："+VipId+Price+VipType);
        model.addAttribute("form", pay);
        return "pay";
    }

    @GetMapping("/return")
    public String returnNotice(String out_trade_no, Model model){
        String query = alipayUtil.query(out_trade_no);
        model.addAttribute("query", query);
        return "query";
    }

    @PostMapping("/notify")
    public void notifyUrl(String trade_no, String total_amount, String trade_status){
        System.err.println("支付宝订单编号：" + trade_no + ", 订单金额： " + total_amount + ",订单状态：" + trade_status);
    }

}
