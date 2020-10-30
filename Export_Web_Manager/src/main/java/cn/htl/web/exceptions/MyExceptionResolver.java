package cn.htl.web.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1：实现接口
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //Exception e 表示由程序抛出来的异常
        //返回值 为什么是 ModelAndView?  添加数据 再将数据显示在指定页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e.getMessage());//添加异常信息
        mv.setViewName("error");//指定一个显示错误的美观页面
        return mv;
    }
}
