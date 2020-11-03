package cn.htl.web.controller.system.module;

import cn.htl.domain.Result;
import cn.htl.domain.system.module.Module;
import cn.htl.service.system.module.IModuleService;

import cn.htl.web.controller.BaseController;
import cn.htl.web.controller.system.role.RoleController;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ModuleController
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/2 9:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/module")
public class ModuleController extends BaseController {

    private static  final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    IModuleService moduleService;

    @RequestMapping(path = "/toList",method = {RequestMethod.POST,RequestMethod.GET})
    public String toList(@RequestParam(defaultValue = "1") Integer curr , @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<Module> pi= moduleService.findByPageInfo(curr,pageSize);

        log.info("pi+"+pi);
        request.setAttribute("pi",pi);
        return "system/module/module-list";
    }
    @RequestMapping(path="/toAdd",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toAdd(){
        //页面上有一个下拉菜单 ，需要查询所有的模块
        List<Module> list = moduleService.findAllModules();
        //添加到request
        request.setAttribute("list",list);
        return "system/module/module-add";
    }
    @RequestMapping(path="/add",method ={ RequestMethod.GET, RequestMethod.POST})
    public String add(Module module){//接收页面提交过来的表单数据

        moduleService.saveModule(module);
        return "redirect:/admin/module/toList.do";
    }
    //${path}/system/module/toUpdate.do?moduleId=${o.moduleId}
    @RequestMapping(path="/toUpdate",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toUpdate(String moduleId){//需要使用参数接收提交的 moduleId
        //需要根据moduleId查询当前模块的记录，回显

        Module module =  moduleService.findModuleById(moduleId);
        request.setAttribute("module",module);

        //当前页面有一个下拉菜单 ，所以给下拉菜单查模块数据
        List<Module> modules = moduleService.findAllModules();
        request.setAttribute("modules",modules);
        return "system/module/module-update";
    }

    //action="${path}/system/module/update.do"
    @RequestMapping(path="/update",method ={ RequestMethod.GET, RequestMethod.POST})
    public String update(Module module){//需要接收编辑页面提交的表单数据
        //更新
        moduleService.updateModule(module);
        return "redirect:/admin/module/toList.do";
    }

    //    '${path}/system/module/delete.do?moduleId='+id;
//    {code:200,msg:'删除成功',data:null}
    @RequestMapping(path="/delete",method ={ RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Object delete(String moduleId){//参数接收页面js提交过来的moduleId

        boolean flag = moduleService.deleteModuleById(moduleId);
        if(flag){
            return Result.init(200,"删除成功",null);
        }else{
            return Result.init(-200,"不能删除当前模块,被子模块引用!!!",null);
        }
    }
}
