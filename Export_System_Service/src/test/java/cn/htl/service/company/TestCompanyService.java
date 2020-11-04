package cn.htl.service.company;

import cn.htl.domain.company.Company;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
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
    @Test
    public void test02(){
        //1:编写了业务逻辑的测试
        //等号 左边是接口 右边是实现类
        //ICompanyService  service = new CompanyServiceImpl();
        List<Company> list = service.findAll();
        System.out.println(list);
    }
    @Test
    public void test03(){
        int currentPage = 1;
        int pageSize = 3;
        //PageInfo 包含四个整数 一个集合
        PageInfo<Company> pi = service.findPage(currentPage,pageSize);

        System.out.println("test06 pi = "+pi);
    }
    @Test
    public void test04(){
        String id = "7f2a7416-2ffc-4f8d-bb90-3e79f2b87170";
        service.deleteById(id);
    }
    @Test
    public void test05(){
        //
        String id = "11111111";
        Company company = service.findById(id);
        System.out.println(company);
    }
    @Test
    public void test06(){
        //
        Company company = new Company("id1","name1",new Date(),"address1","licenseId","representative","phone","companySize","industry","remarks",0,100.0,"city");
        service.saveCompany(company);
    }

}