package cn.htl.web.controller.system.dept;

import cn.htl.domain.system.dept.Dept;
import cn.htl.service.system.dept.IDeptService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/29 21:06
 * @Version 1.0
 */

@Controller
@RequestMapping("/admin/dept")
public class DeptController {
    @Autowired
    IDeptService iDeptService;

    private static  final Logger l = LoggerFactory.getLogger(DeptController.class);
    //localhost:8080/export_web/system/dept/toList.do?curr=1&pageSize=3&companyId=1
    @RequestMapping(path="/toList",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toList(Model model, @RequestParam(defaultValue = "1") Integer curr,
                         @RequestParam(defaultValue = "5")  Integer pageSize,
                         @RequestParam(defaultValue = "1")  String companyId){

        l.info("toList curr = "+curr);//当前第几页
        l.info("toList pageSize = "+pageSize);//每页记录数
        l.info("toList companyId = "+companyId);//指定公司id
        //查询一个分页
        PageInfo<Dept> pi = iDeptService.findByPage(curr, pageSize, companyId);

        l.info("toList pi = "+pi);
        model.addAttribute("pi",pi);
        return "system/dept/dept-list";
    }
    @RequestMapping(path="/toAdd",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toAdd(Model model,@RequestParam(defaultValue = "1") String companyId){
        //需要为下拉菜单查询出所有的部门，一个部门对应一个选项
        //根据companyId查询出部门，不做分页
        l.info("toAdd companyId="+companyId);
        List<Dept> list=iDeptService.findAll(companyId);

        l.info("toAdd list="+list);
        model.addAttribute("list",list);
        return "system/dept/dept-add";
    }

    // action="${path}/system/dept/add.do"

    @RequestMapping(path="/add",method ={  RequestMethod.POST})
    public String add(Dept dept,String parentId){
        l.info("add  dept="+dept);
        l.info("add  parentId="+parentId);
        //现在默认公司id是1，后面再修改
        dept.setCompanyId("1");

        Dept parent = new Dept();
        parent.setDeptId(parentId);

        dept.setParent(parent);
        //保存到数据库
        iDeptService.saveDept(dept);
        return "redirect:/system/dept/toList.do";

    }


    // ${path}/system/dept/toUpdate.do?deptId=${dept.deptId}
    @RequestMapping(path="/toUpdate",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toUpdate(Model model, String deptId){

        String companyId = "1";
        l.info("toUpdate deptId="+deptId);

        //查询部门
        Dept dept = iDeptService.findById(deptId);
        l.info("toUpdate dept="+dept);

        List<Dept> list = iDeptService.findAll(companyId);

        model.addAttribute("dept",dept);
        model.addAttribute("list",list);

        return "system/dept/dept-update";
    }
}
