package cn.htl.web.controller.system.role;

import cn.htl.domain.Result;
import cn.htl.domain.system.role.Role;
import cn.htl.service.system.role.IRoleService;
import cn.htl.web.controller.BaseController;
import org.springframework.ui.Model;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName RoleController
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 14:35
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController {
    private static  final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IRoleService roleService;

    @RequestMapping(path = "/toList",method = {RequestMethod.POST,RequestMethod.GET})
    public String toList( @RequestParam(defaultValue = "1") Integer curr , @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<Role> pi= roleService.findByPage(curr,pageSize,getLoginCompanyId());
        log.info("pi+"+pi);
        request.setAttribute("pi",pi);
        return "system/role/role-list";
    }

    @RequestMapping(path = "/toAdd",method = {RequestMethod.POST,RequestMethod.GET})
    public String toAdd(){
        return "system/role/role-add";
    }
    @RequestMapping(path = "/add",method = {RequestMethod.POST,RequestMethod.GET})
    public String add(Role role){
        log.info("role"+role);
        role.setCompanyId(getLoginCompanyId());
        role.setCompanyName(getLoginCompanyName());
        roleService.saveRole(role);
        return "redirect:/admin/role/toList.do";
    }

    @RequestMapping(path = "/toUpdate",method = {RequestMethod.POST,RequestMethod.GET})
    public String toUpdate(String roleId){
        Role role = roleService.findById(roleId);

        log.info("add+"+role);

        request.setAttribute("role",role);
        return "system/role/role-update";
    }

    @RequestMapping(path = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    public String update(Role role){
        log.info("update+"+role);
        role.setCompanyId(getLoginCompanyId());
        role.setCompanyName(getLoginCompanyName());
        roleService.updateRole(role);

        return "redirect:/admin/role/toList.do";
    }

    @RequestMapping(path = "/delete",method = {RequestMethod.POST,RequestMethod.GET})
    public Object delete(String roleId){

        log.info("delete+"+roleId);
        try {
            roleService.deleteRole(roleId);
            return Result.init(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.init(404,"删除失败",null);
        }
    }

    @RequestMapping(path = "/toRoleModule",method = {RequestMethod.POST,RequestMethod.GET})
    public String toRoleModule(){
        return "system/role/role-module";
    }
}
