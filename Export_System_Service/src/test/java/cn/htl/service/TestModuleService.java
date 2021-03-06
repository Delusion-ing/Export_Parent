package cn.htl.service;

import cn.htl.domain.system.module.Module;
import cn.htl.domain.system.user.User;
import cn.htl.service.system.module.IModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName TestModuleService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/3 22:05
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestModuleService {

    @Autowired
    IModuleService moduleService;

    @Test
    public void test01() {

        List<Module> myList = moduleService.findModuleByRoleId("10c4b647-cafa-4df4-9074-96c4e3f53210");
        System.out.println("myList = " + myList);
    }
    @Test
    public void test02(){
        //修改一个角色的权限，不仅仅是添加，也可能是减少
        String roleId="10c4b647-cafa-4df4-9074-96c4e3f53210";
        //String moduleIds="201,202";//减少指定角色的权限
        String moduleIds="201,202,203";//添加角色的权限
        moduleService.updateRoleModule(roleId,moduleIds);
    }
    @Test
    public void test03(){

        User user = new User();
        user.setUserId("002108e2-9a10-4510-9683-8d8fd1d374ef");
        //user.setDegree(0);
        //user.setDegree(1);//企业管理员
        user.setDegree(4);//普通用户
        //一个 Module对象 就是左侧栏上的一个菜单项
        List<Module> menus = moduleService.findModulesByUser(user);
        System.out.println("test03"+menus);

    }


}
