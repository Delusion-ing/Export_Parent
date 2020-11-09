package cn.htl.service.system.user.impl;

import cn.htl.dao.system.user.IUserDao;
import cn.htl.domain.system.user.User;
import cn.htl.service.system.user.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName IUserServiceImpl
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/3 14:14
 * @Version 1.0
 */
@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public PageInfo<User> findByPageInfo(int curr, int pageSize ,String companyId) {
        PageHelper.startPage(curr, pageSize);
        List<User> list = userDao.findPage(companyId);
        PageInfo<User> pi = new PageInfo<>(list);
        return pi;
    }

    @Override
    public void saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        if (user.getPassword() !=  null){
            Md5Hash md5Hash = new Md5Hash(user.getPassword(),user.getEmail());//参1 明文  参2 盐
            user.setPassword(md5Hash.toString());
        }
        userDao.save(user);
    }

    @Override
    public PageInfo<User> searcher(int curr, int pageSize, String userName) {
        PageHelper.startPage(curr, pageSize);
        List<User> list = userDao.searcher(userName);
        PageInfo<User> pi = new PageInfo<>(list);
        return pi;
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findUserById(String userId) {
        return userDao.findById(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public boolean deleteUserById(String userId) {
        userDao.delete(userId);
        return false;
    }
}
