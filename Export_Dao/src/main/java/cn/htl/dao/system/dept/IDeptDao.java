package cn.htl.dao.system.dept;

import cn.htl.domain.system.dept.Dept;

import java.util.List;

public interface IDeptDao {
    List<Dept> findAll(String companyId);
    Dept findById(String deptId);

    void save(Dept dept);

    void update(Dept dept);

    int findParentCount(String deptId);
    void deleteById(String deptId);
}
