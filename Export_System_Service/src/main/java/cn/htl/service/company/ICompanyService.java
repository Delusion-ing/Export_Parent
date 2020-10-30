package cn.htl.service.company;

import cn.htl.domain.company.Company;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICompanyService {
    List<Company> findAll();

    PageInfo<Company> findPage(int currentPage, int pageSize);

    void updateCompany(Company company);

    Company findById(String id);

    void deleteById(String id);

    void saveCompany(Company company);
}
