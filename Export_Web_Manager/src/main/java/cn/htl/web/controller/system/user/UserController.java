package cn.htl.web.controller.system.user;

import cn.htl.dao.system.dept.IDeptDao;
import cn.htl.dao.system.user.IUserDao;
import cn.htl.domain.Result;
import cn.htl.domain.system.dept.Dept;
import cn.htl.domain.system.role.Role;
import cn.htl.domain.system.user.User;
import cn.htl.service.system.dept.IDeptService;
import cn.htl.service.system.role.IRoleService;
import cn.htl.service.system.user.IUserService;
import cn.htl.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/3 17:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;
    @Autowired
    IDeptService deptService;
    @Autowired
    IRoleService roleService;

    @RequestMapping(path="/toList",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toList(@RequestParam(defaultValue = "1") int curr, @RequestParam(defaultValue = "6")int pageSize){
        //调查询分页列表的方法
        PageInfo<User> pi = userService.findByPageInfo(curr, pageSize,getLoginCompanyId());
        //将pi添加到页面
        request.setAttribute("pi",pi);
        return "system/user/user-list";
    }

    // var url= '${path}/system/user/delete.do?userId='+id;
    //  var fn = function(result){ //{code:200,msg:'删除成功',data:null}
    @RequestMapping(path="/delete",method ={ RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Object delete(String userId){//参数接收页面js提交过来的userId
        boolean flag = userService.deleteUserById(userId);
        if(flag){
            return Result.init(200,"删除成功",null);
        }else{
            return Result.init(-200,"删除失败",null);
        }
    }

//    @RequestMapping(path="/searcherUI",method ={ RequestMethod.GET, RequestMethod.POST})
//    public String searcherUI(){
//        //页面上有一个下拉菜单 ，需要查询所有的部门
//        List<Dept> depts = deptService.findAll(getLoginCompanyId());
//        //添加到request
//        request.setAttribute("depts",depts);
//        return "system/user/user-add";
//    }


    @RequestMapping(path="/searcher",method ={ RequestMethod.GET, RequestMethod.POST})
    public String searcher(@RequestParam(defaultValue = "1") int curr, @RequestParam(defaultValue = "6")int pageSize ,String userName){
        //调查询分页列表的方法
        PageInfo<User> pi = userService.searcher(curr, pageSize,userName);
        //将pi添加到页面
        User user = new User();
        System.out.println(user.getUserName());
        request.setAttribute("pi",pi);
        return "system/user/user-list";
    }

    @RequestMapping(path = "/toUpdate",method = {RequestMethod.POST,RequestMethod.GET})
    public String toUpdate(String userId){

        User user =  userService.findUserById(userId);
        request.setAttribute("user",user);
        List<Dept> depts = deptService.findAll(getLoginCompanyId());
        request.setAttribute("depts",depts);
        return "system/user/user-update";
    }

    @RequestMapping(path = "/update",method = {RequestMethod.POST,RequestMethod.GET})
    public String update(User user){
        userService.updateUser(user);

        return "redirect:/admin/user/toList.do";
    }



    @RequestMapping(path="/toAdd",method ={ RequestMethod.GET, RequestMethod.POST})
    public String toAdd(){
        //页面上有一个下拉菜单 ，需要查询所有的部门
        List<Dept> depts = deptService.findAll(getLoginCompanyId());
        //添加到request
        request.setAttribute("depts",depts);
        return "system/user/user-add";
    }
    //  ${path}/system/user/add.do
    @RequestMapping(path="/add",method ={ RequestMethod.GET, RequestMethod.POST})
    public String add(User user){//接收页面提交过来的表单数据

        //用户或者员工属于一家公司，所以公司companyId是必须的
        user.setCompanyId(getLoginCompanyId());
        user.setCompanyName(getLoginCompanyName());

        userService.saveUser(user);


        return "redirect:/admin/user/toList.do";
    }
    @RequestMapping(path="/userRole",method ={ RequestMethod.GET, RequestMethod.POST})
    public String userRole(String userId){
        User user = userService.findUserById(userId);
        request.setAttribute("user",user);

        //查询角色
        String companyId = getLoginCompanyId();
        List<Role> roles = roleService.finAll(companyId);

        List<Role> userRoleList = roleService.finRolesByUserId(userId);

        for (Role role :roles){
            if (isInUserRoleList(role,userRoleList)){
                role.setChecked(true);
            }
        }
        request.setAttribute("roles",roles);
        request.setAttribute("userRoleList",userRoleList);
        return "system/user/user-role";
    }
    private boolean isInUserRoleList(Role role, List<Role> userRoleList) {
        for( Role r:userRoleList){
            if(r.getRoleId().equals(role.getRoleId())){
                return true;
            }
        }
        return false;
    }

    @RequestMapping(path = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(String email,String password) {
        User user = userService.findUserByEmail(email);
        if (user != null) {
            //1:找到
            //比较账号密码
            if (user.getPassword().equals(password)) {
                //正确
                session.setAttribute("loginUser", user);
                return "redirect:/home/toMain.do";
            } else {
                //密码不对
                request.setAttribute("error", "邮箱或者密码不正确");
                return "forward:/login.jsp";
            }
        } else {
            request.setAttribute("error", "用户名不正确");
            return "forward:/login.jsp";

        }
    }

    @RequestMapping(path = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout() {
        session.removeAttribute("loginUser");

        session.invalidate();

        return "redirect:/login.jsp";

    }

}
