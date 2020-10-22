package cn.htl.service.company;

import cn.htl.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//2：添加spring的单元测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")  //3:创建 spring/applicationContext-tx.xml
public class TestCompanyService {
    @Autowired
    ICompanyService  service;
    @Test
    public void test01(){
        //1:编写了业务逻辑的测试
        //等号 左边是接口 右边是实现类
        //ICompanyService  service = new CompanyServiceImpl();
        List<Company> list = service.findAll();
        System.out.println(list);
    }
}