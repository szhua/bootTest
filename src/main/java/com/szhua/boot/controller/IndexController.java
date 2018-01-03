package com.szhua.boot.controller;
/*
*@author szhua 2018/1/2/002
*IndexController
github@szhua
*/


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public String index(ModelMap model){
       model.addAttribute("title",getClass().getName());
        return "index" ;
    }
    @RequestMapping(value = "login" ,method = RequestMethod.GET)
    public String login(){
     return  "login" ;
    }









}
