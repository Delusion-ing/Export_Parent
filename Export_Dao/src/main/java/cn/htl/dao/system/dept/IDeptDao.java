package cn.htl.dao.system.dept;

import cn.htl.domain.system.dept.Dept;

import java.util.List;

/**
 * @ClassName dept
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/29 20:49
 * @Version 1.0
 */

public interface IDeptDao {
    List<Dept> findAll(String companyId);

    Dept findById(String deptId);

    void save(Dept dept);

    List<Dept> findAllDept();
}