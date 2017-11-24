package com.mylzs.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 17/11/23.
 */
@Controller
@RequestMapping("/w")
public class ViewController {
    @RequestMapping("/view")
    @ResponseBody
    public String view(){
        return "hahah";
    }
    @RequestMapping("/login")
    public String login(){
     return "admin/login";
    }
}
