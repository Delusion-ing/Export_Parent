package cn.htl.dao.system.module;

import cn.htl.domain.system.module.Module;

import java.util.List;

/**
 * @ClassName IModuleDao
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 16:39
 * @Version 1.0
 */
public interface IModuleDao {
    List<Module> findPage();

    void save(Module module);

    Module findById(String moduleId);

    void update(Module module);

    void delete(String moduleId);

    int findParentIdCount(String moduleId);

    List<Module> findByRoleId(String roleId);

    void saveRoleModule(String roleId, String mid);

    List<Module> findByBelong(String belong);

    List<Module> findByUserId(String userId);
}
