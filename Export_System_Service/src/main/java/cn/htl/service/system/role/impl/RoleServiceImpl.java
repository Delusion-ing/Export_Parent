package cn.htl.service.system.role.impl;

import cn.htl.dao.system.role.IRoleDao;
import cn.htl.domain.system.role.Role;
import cn.htl.service.system.role.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 15:09
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;
    @Override
    public PageInfo<Role> findByPage(int curr, int pageSize, String companyId) {
        PageHelper.startPage(curr, pageSize);
        List<Role> list = roleDao.findAll(companyId);
        PageInfo<Role>  pi = new PageInfo<>(list);
        return pi;
    }

    @Override
    public void saveRole(Role role) {
        String uuid = UUID.randomUUID().toString();
        role.setRoleId(uuid);
        roleDao.save(role);

    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.update(role);
    }

    @Override
    public void deleteRole(String roleId) {
        roleDao.deleteById(roleId);
    }

    @Override
    public List<Role> finRolesByUserId(String userId) {
        return roleDao.findByUserId(userId);
    }

    @Override
    public List<Role> finAll(String companyId) {
        return roleDao.findAll(companyId);
    }

    @Override
    public void updateUserRole(String userId, String[] roleIds) {
        //删除
        roleDao.deleteUserRoleByUserId(userId);//删除 用户角色中间表

        for(String roleId:roleIds){
            roleDao.saveUserRole(userId,roleId);
        }
    }
}
