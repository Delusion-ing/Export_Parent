package cn.htl.service;

import cn.htl.domain.system.module.Module;
import cn.htl.domain.system.role.Role;
import cn.htl.service.system.role.IRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName TestRoleService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/4 20:55
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestRoleService {
    @Autowired
    IRoleService roleService;

    @Test
    public void test01() {

        List<Role> myList = roleService.finRolesByUserId("002108e2-9a10-4510-9683-8d8fd1d374ef");
        System.out.println("myList = " + myList);
    }
}
