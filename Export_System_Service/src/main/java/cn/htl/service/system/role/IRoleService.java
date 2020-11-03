package cn.htl.service.system.role;

import cn.htl.domain.system.role.Role;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName IRoleService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 14:50
 * @Version 1.0
 */
public interface IRoleService {
    PageInfo<Role> findByPage(int curr, int pageSize, String companyId);

    void saveRole(Role role);

    Role findById(String roleId);

    void updateRole(Role role);


    void deleteRole(String roleId);
}
