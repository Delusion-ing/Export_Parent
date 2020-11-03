package cn.htl.service.system.user;

import cn.htl.domain.system.user.User;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/3 14:13
 * @Version 1.0
 */
public interface IUserService {
    PageInfo<User> findByPageInfo(int curr, int pageSize,String companyId);

    User findUserById(String userId);

    void updateUser(User user);

    boolean deleteUserById(String userId);

    void saveUser(User user);

    PageInfo<User> searcher(int curr, int pageSize, String userName);
}
