package cn.htl.web.utils;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//创建自己的密码匹配器，必须指定父类
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    private Logger l = LoggerFactory.getLogger(this.getClass());

    //将密码加密成密文，但需要使用账号作盐
    //subject.login(token) 表示的页面提交的密码 123 -> 密文1
    //info  调relam 表示的是数据中的密码  密文2
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //token获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String email = t.getUsername();
        //密码是char[] '1','2','3'  => "123"  new String(char[])
        String pwd1 = new String(t.getPassword());
        l.info("doCredentialsMatch pwd1 "+pwd1);
        //加密
        Md5Hash md5Hash = new Md5Hash(pwd1, email);//参1 传入明文  参2盐
        pwd1 = md5Hash.toString();
        l.info("doCredentialsMatch pwd1 "+pwd1);

        //取数据库的密码 此时不用再加密码，因为它就是密文
        String pwd2 = (String) info.getCredentials();
        l.info("doCredentialsMatch pwd2 "+pwd2);
        if (pwd1.equals(pwd2)) {
            return true;//密码正确
        } else {
            return false;//密码不正确
        }

    }
}
