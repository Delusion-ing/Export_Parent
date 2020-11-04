package cn.htl.service.company;

import cn.htl.domain.system.dept.Dept;
import cn.htl.service.system.dept.IDeptService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName TestDeptService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/29 20:58
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class TestDeptService {
    private static final Logger l = LoggerFactory.getLogger(TestDeptService.class);

    //1:注入部门业务类
    //1.1定义接口
    //1.2定义了实现类
    //1.3在实现类上加@Service
    @Autowired
    IDeptService iDeptService;
    @Test
    public void test01(){
        //部门分页显示
        int curr=1;
        int pageSize=3;
        String  companyId="1";
        //2 调用分页查找方法
        PageInfo<Dept> pi = iDeptService.findByPage(curr,pageSize,companyId);//整数   参1 当前第几页  参2 每页多少条 参3 公司id
        //打印
        l.info("test01 pi="+pi);
    }
    @Test
    public void test02(){
        //给页面的下拉菜单按公司查找所有的部门
        String  companyId="1";
        //2 调用分页查找方法
        List<Dept> list = iDeptService.findAll(companyId);//
        //打印
        l.info("test02 list="+list);
    }
    @Test
    public void test03(){
        //模拟表单
        Dept dept = new Dept();
        dept.setCompanyId("1");
        dept.setDeptName("最牛13java部门");
        dept.setState(1);

        Dept parent = new Dept();
        parent.setDeptId("100101101");

        dept.setParent(parent);
        //保存到数据库
        iDeptService.saveDept(dept);
    }


    @Test
    public void test04(){
        //deptId=100101
        String deptId="100101";
        Dept dept = iDeptService.findById(deptId);

        l.info("test04  dept="+dept);
    }
}