package cn.htl.web.controller.system.role;

import cn.htl.domain.Result;
import cn.htl.domain.system.module.Module;
import cn.htl.domain.system.role.Role;
import cn.htl.service.system.module.IModuleService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    IModuleService moduleService;

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


    //location.href="${path}/system/role/toRoleModule.do?roleId="+id;
    @RequestMapping(path="/roleModule",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toRoleModule(String roleId){//接收页面提交的roleId
        Role role = roleService.findById(roleId);

        //数据转发到页面
        request.setAttribute("role",role);
        return "system/role/role-module";
    }

    //$.get('${path}/role/getZtreeData.do?roleId=${role.roleId}',fn,'json')

    @RequestMapping(path="/getZtreeData",method ={ RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Object getZtreeData(String roleId) {//接收页面提交的roleId
        //所有的权限查询出来
        List<Module> all = moduleService.findAllModules();
        //转换成 List<Map<String,Object>>  { id:1, pId:0, name:"Sass管理", open:true},
        //根据 roleId查 该角色的权限
        List<Module> myList = moduleService.findModuleByRoleId(roleId);
        List<Map<String,Object>> list = new ArrayList<>();
        //返回给页面
        for(Module m:all){
            //生成一个集合 Map<String,Object> 表示一节点
            Map<String,Object> node = new HashMap<String,Object>();
            node.put("id",m.getModuleId());
            node.put("pId",m.getParentId());
            node.put("name",m.getName());
            node.put("open",true);
            if(isInMyList(m,myList)){
                node.put("checked",true);//为了在菜单页面上打上勾。有打勾就表示有这个权限，否则就是没有
            }
            //添加到集合中
            list.add(node);
        }
        return list;//@ResponseBody将list转成json
    }

    //需要判断m是否在myList里面，如果在表示该角色有这个权限，否则没有
    private boolean isInMyList(Module m, List<Module> myList) {
        for(Module my:myList){
            if(m.getModuleId().equals(my.getModuleId())){
                return true;
            }
        }//end for 循环结束
        return false;
    }

    @RequestMapping(path = "/updateRoleModule",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateRoleModule(String roleId, String moduleIds){

        moduleService.updateRoleModule(roleId,moduleIds);

        return "redirect:/admin/role/toList.do";

    }



}
