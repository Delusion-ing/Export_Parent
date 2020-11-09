package cn.htl.web.utils;

import cn.htl.domain.system.log.Log;
import cn.htl.domain.system.user.User;
import cn.htl.service.system.log.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 19:04
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {
    private Logger log = LoggerFactory.getLogger(LogAspect.class);
    public LogAspect(){
        log.info("LogAspect 无参构造方法执行");

    }

    @Around(value = "execution(* cn.htl.web.controller..*.*Controller.*(..))")
    public Object writeLog(ProceedingJoinPoint jp){

        Object result = null;
        try {
            result = jp.proceed();

            log.info("切面：writeLog");
            saveLog(jp);
        } catch (Throwable e) {

        }finally {

        }
        return result;
    }

    @Autowired
    ILogService logService;
    @Autowired
    HttpSession httpSession;
    @Autowired
    HttpServletRequest httpServletRequest;

    private void saveLog(ProceedingJoinPoint jp) {

        Log log = new Log();

        User user = (User) httpSession.getAttribute("loginUser");

        if (user != null){
            log.setUserName(user.getUserName());
            log.setCompanyId(user.getCompanyId());
            log.setCompanyName(user.getCompanyName());
        }

        log.setIp(httpServletRequest.getRemoteAddr());

        log.setTime(new Date());
        log.setMethod(jp.getSignature().getName());

        log.setAction(jp.getTarget().getClass().getName());

        System.out.println("saveLog："+log);
        logService.saveSysLog(log);
    }

}
