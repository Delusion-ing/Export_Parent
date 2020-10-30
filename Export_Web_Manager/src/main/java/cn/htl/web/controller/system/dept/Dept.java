package cn.htl.web.controller.system.dept;

import cn.htl.service.system.dept.IDeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/30 9:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/dept")
public class Dept {
    @Autowired
    IDeptService iDeptService;
    @RequestMapping(path="/toList",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toList(Model model, Integer curr, Integer pageSize, String companyId){

        //调service获取数据
        if (curr == null) {
            curr = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        //查询一个分页
        PageInfo<cn.htl.domain.system.dept.Dept> pi = iDeptService.findBy(curr, pageSize, companyId);



        model.addAttribute("pi",pi);
        return "system/dept/dept-list";
    }
}
