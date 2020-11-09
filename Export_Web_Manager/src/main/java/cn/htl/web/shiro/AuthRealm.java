package cn.htl.web.shiro;


import cn.htl.domain.system.module.Module;
import cn.htl.domain.system.user.User;
import cn.htl.service.system.module.IModuleService;
import cn.htl.service.system.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


//不需要再添加@Component 因为在xml中使用bean标签配置了
//AuthorizingRealm 认证（登录账号密码）和 授权（查有什么权限）
public class AuthRealm extends AuthorizingRealm {
    private Logger l = LoggerFactory.getLogger(this.getClass());
    //spring是通过反射调用无参构造函数
    public AuthRealm(){
        l.info("AuthRealm 无参构造函数执行了");
    }
    //授权（查有什么权限）
    @Autowired
    IModuleService moduleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        l.info("AuthRealm doGetAuthorizationInfo 函数执行了");
        //获取用户信息
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();//session
        l.info("doGetAuthorizationInfo user "+user);//当前用户是谁
        if(user != null){
            //要求查询当前账号email包含哪些权限(中文表示)
            List<Module> list = moduleService.findModulesByUser(user);
            SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
            //循环
            for(Module m:list){
                l.info("doGetAuthorizationInfo m "+m.getName());
                //将字符串表示的权限名称添加到shiro
                info.addStringPermission( m.getName());
            }//end for
            return info;
        }//end if
        return null;
    }
    //认证（登录账号密码）
    //subject.login(token);
    //参1 接受 subject.login(token); 方法的值  authenticationToken

    @Autowired
    IUserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        l.info("AuthRealm doGetAuthenticationInfo 函数执行了");
        //响应login方法和getPrincipal方法的调用
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String email = usernamePasswordToken.getUsername();
        l.info("doGetAuthenticationInfo --" + email);
        //调service读dao
        User user = userService.findUserByEmail(email);
        l.info("doGetAuthenticationInfo --" + user);
        if (user == null) {
            //用户不存在
            return null;//-->系统会将null转成UnknownAccountException抛出
        } else {
            //用户存在的
            //AuthenticationInfo 返回给 User user = (User) subject.getPrincipal();
            /**
             * 参数一：principal，存放用户登录信息，subject.getPrincipal()获取
             * 参数二：数据库的密码
             * 参数三：realm的别名，只有在多个Realm的时候才会用，一般不用
             */
            AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");
            return info;
        }
    }
}
