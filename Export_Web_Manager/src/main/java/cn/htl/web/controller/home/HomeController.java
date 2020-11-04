package cn.htl.web.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//交给springmvc
@Controller
@RequestMapping("/home")
public class HomeController {
    //主要是负责打开页面的，没有逻辑
    @RequestMapping(path="/toMain",method = RequestMethod.GET)
    public String toMain(){
        return "home/main";
    }
    @RequestMapping(path="/toHome",method = {RequestMethod.GET,RequestMethod.POST})
    public String toHome(){
        return "home/home";
    }
}
