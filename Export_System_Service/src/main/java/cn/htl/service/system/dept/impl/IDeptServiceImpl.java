package cn.htl.service.system.dept.impl;

import cn.htl.dao.system.dept.IDeptDao;
import cn.htl.domain.system.dept.Dept;
import cn.htl.service.system.dept.IDeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName IDeptServiceImpl
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/29 20:59
 * @Version 1.0
 */
@Service
public class IDeptServiceImpl implements IDeptService {
    //还需要注入dao 根据三层架构  service调用dao
    @Autowired
    IDeptDao iDeptDao;
    @Override
    public PageInfo<Dept> findByPage(int curr, int pageSize, String companyId) {
        //调用dao查询所有的记录
        //select * from dept;
        //select count(*) from dept;
        //select * from dept limit 0,20;
        PageHelper.startPage(curr,pageSize);
        List<Dept> list =  iDeptDao.findAll(companyId);
        return new PageInfo<>(list);
    }

    public PageInfo<Dept> findBy(int curr, int pageSize, String companyId) {
        //调用dao查询所有的记录
        //select * from dept;
        //select count(*) from dept;
        //select * from dept limit 0,20;
        PageHelper.startPage(curr, pageSize);
        List<Dept> list = iDeptDao.findAllDept();
        return new PageInfo<>(list);
    }

    @Override
    public List<Dept> findAll(String companyId) {
        List<Dept> list =  iDeptDao.findAll(companyId);
        return list;
    }

    @Override
    public void saveDept(Dept dept) {
        //表的id都不是自动生成的
        String id = UUID.randomUUID().toString();
        dept.setDeptId(id);

        //调用dao进行保存
        iDeptDao.save(dept);
    }

    @Override
    public Dept findById(String deptId) {
        return iDeptDao.findById(deptId);
    }
}
