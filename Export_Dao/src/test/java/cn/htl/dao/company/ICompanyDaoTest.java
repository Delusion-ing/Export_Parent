package cn.htl.dao.company;

import cn.htl.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//spring的junit测试的两个注解
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class ICompanyDaoTest {

    //可以通过@Autowrie 去 spring中获取dao的实现类对象
    @Autowired
    ICompanyDao iCompanyDao;//=new 实现类()
    @Test
    public void findAll() {
        System.out.println(iCompanyDao);
        //返回所有的企业
        List<Company> list = iCompanyDao.findAll();
        System.out.println(list);
    }
}