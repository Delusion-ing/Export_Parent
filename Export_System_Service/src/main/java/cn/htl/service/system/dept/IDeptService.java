package cn.htl.service.system.dept;

import cn.htl.domain.system.dept.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName IDeptService
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/29 20:57
 * @Version 1.0
 */
public interface IDeptService {
    //查询指定公司id的第几个部门分页
    PageInfo<Dept> findByPage(int curr, int pageSize, String companyId);
    //根据companyId查找该公司下面的所有的部门
    List<Dept> findAll(String companyId);
    //新建一个部门
    void saveDept(Dept dept);
    //查找指定id的部门
    Dept findById(String deptId);

    PageInfo<Dept> findBy(int curr, int pageSize, String companyId);


}
