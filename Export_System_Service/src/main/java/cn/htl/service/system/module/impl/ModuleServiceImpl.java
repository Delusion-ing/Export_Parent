package cn.htl.service.system.module.impl;

import cn.htl.dao.system.module.IModuleDao;
import cn.htl.domain.system.module.Module;
import cn.htl.service.system.module.IModuleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName ModuleServiceImpl
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/1 19:35
 * @Version 1.0
 */
@Service
public class ModuleServiceImpl implements IModuleService {
    @Autowired
    IModuleDao moduleDao;

    @Override
    public PageInfo<Module> findByPageInfo(int curr, int pageSize) {
        PageHelper.startPage(curr, pageSize);
        List<Module> list = moduleDao.findPage();
        PageInfo<Module> pi = new PageInfo<>(list);
        return pi;
    }

    @Override
    public void saveModule(Module module) {
        String id = UUID.randomUUID().toString();
        module.setModuleId(id);
        moduleDao.save(module);

    }

    @Override
    public Module findModuleById(String moduleId) {
        return moduleDao.findById(moduleId);
    }

    @Override
    public void updateModule(Module module) {
        moduleDao.update(module);
    }

    @Override
    public boolean deleteModuleById(String moduleId) {
        int count = moduleDao.findParentIdCount(moduleId);
        if (count == 0){
            moduleDao.delete(moduleId);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Module> findAllModules() {
        return null;
    }
}
