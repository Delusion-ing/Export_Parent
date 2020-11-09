package cn.htl.service;

import cn.htl.domain.system.log.Log;
import cn.htl.service.system.log.ILogService;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @ClassName TestLogService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 15:57
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestLogService {

    @Autowired
    ILogService logService;
    //增*删改查*
    @Test
    public void test01(){
        //分页列表
        //页面上显示分页列表，就要求业务方法中提供查询PageInfo的方法
        PageInfo<Log> pi= logService.findByPage(1,3,"1");
        System.out.println("test01"+pi);
    }
    @Test
    public void test02(){

        //将一个表单数据保存在javaBean中，再将javaBean存到数据库
        Log log = new Log();
        //设置登录用户信息
        log.setUserName("虎太郎plus");
        //设置企业信息
        log.setCompanyId("1");
        log.setCompanyName("吉首大学张家界学院");
        //IP地址
        log.setIp("192.168.10.11");
        //设置记录时间
        log.setTime(new Date());
        //执行的方法名称
        log.setMethod("toList");
        //执行的类名称
        log.setAction("cn.htl.web.company.CompanyController");

        log.setCompanyId("1");
        log.setCompanyName("吉首大学");
        logService.saveSysLog(log);

    }
    @Test
    public void test03() {
        Md5Hash md5Hash = new Md5Hash("123","htl848112204@163.com");//参1 传入明文
        System.out.println(md5Hash.toString());
        //cbcfba43086a802a9154ad0a79ad6c46
    }

}

