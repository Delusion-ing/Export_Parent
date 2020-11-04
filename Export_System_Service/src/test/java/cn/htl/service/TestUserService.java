package cn.htl.service;

import cn.htl.domain.system.user.User;
import cn.htl.service.company.TestDeptService;
import cn.htl.service.system.user.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TestUserService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/4 20:02
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestUserService {
    private static final Logger log = LoggerFactory.getLogger(TestDeptService.class);
    @Autowired
    IUserService userService;

    @Test
    public void test01(){
        //根据 email查询对应的用户

        String email = "htl848112204@163.com";
        String password="124";
        User user = userService.findUserByEmail(email);
        log.info("test01 user "+user);
        if (user != null) {
            //1:找到
            //比较账号密码
            if(user.getPassword().equals(password)){
                //正确
                log.info("正确");
            }else{
                //密码不对
                log.info("密码不对");
            }
        }else{
            //2:没找到
            //用户不存在
            log.info("用户不存在");
        }
    }

}
