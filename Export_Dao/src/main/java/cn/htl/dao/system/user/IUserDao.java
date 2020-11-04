package cn.htl.dao.system.user;

import cn.htl.domain.system.user.User;

import java.util.List;

/**
 * @ClassName IUserDao
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/3 14:14
 * @Version 1.0
 */
public interface IUserDao {

    void save(User user);

    List<User> findPage(String companyId);

    User findById(String userId);

    void update(User user);

    void delete(String userId);

    List<User> searcher(String userName);

    User findByEmail(String email);
}
