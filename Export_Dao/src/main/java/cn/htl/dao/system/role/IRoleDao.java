package cn.htl.dao.system.role;

import cn.htl.domain.system.role.Role;

import java.util.List;

/**
 * @ClassName IRoleDao
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 15:10
 * @Version 1.0
 */
public interface IRoleDao {
    List<Role> findAll(String companyId);

    void save(Role role);

    Role findById(String roleId);

    void update(Role role);

    void deleteById(String roleId);

    List<Role> findByUserId(String userId);

    void deleteUserRoleByUserId(String userId);

    void saveUserRole(String userId, String roleId);
}
