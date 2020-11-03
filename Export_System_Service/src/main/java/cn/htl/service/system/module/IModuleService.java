package cn.htl.service.system.module;

import cn.htl.domain.system.module.Module;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName IModuleService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/1 19:22
 * @Version 1.0
 */
public interface IModuleService {
    PageInfo<Module> findByPageInfo(int curr, int pageSize);

    void saveModule(Module module);

    Module findModuleById(String moduleId);

    void updateModule(Module module);

    boolean deleteModuleById(String moduleId);

    List<Module> findAllModules();
}
