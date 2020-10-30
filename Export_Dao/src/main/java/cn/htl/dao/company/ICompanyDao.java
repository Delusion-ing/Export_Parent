package cn.htl.dao.company;

import cn.htl.domain.company.Company;

import java.util.List;

public interface ICompanyDao {
    //查询所有的公司记录
    //select * from ss_company
    List<Company> findAll();

    Company findById(String id);

    void update(Company company);

    void deleteById(String id);

    void save(Company company);
}

