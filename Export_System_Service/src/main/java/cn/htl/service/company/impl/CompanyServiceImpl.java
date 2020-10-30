package cn.htl.service.company.impl;

import cn.htl.dao.company.ICompanyDao;
import cn.htl.domain.company.Company;
import cn.htl.service.company.ICompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service //如果service的实现类需要由spring创建，则打上注解 @Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    ICompanyDao iCompanyDao;
    public List<Company> findAll() {//service要调用dao查询数据，所以要注入
        return iCompanyDao.findAll();
    }

    @Override
    public PageInfo<Company> findPage(int currentPage, int pageSize) {
        //设置参数
        PageHelper.startPage(currentPage,pageSize);
        //查询由拦截器在 select * from ss_company 基础上，生成
        //select count(*) from ss_company
        //select * from ss_company limit (currentPage-1)*pageSize ,pageSize
        List<Company> list = iCompanyDao.findAll();
        //将集合封装
        PageInfo<Company> pi = new PageInfo<>(list);
        return pi;
    }

    @Override
    public void updateCompany(Company company) {
        iCompanyDao.update(company);

    }

    @Override
    public Company findById(String id) {
        Company company = iCompanyDao.findById(id);
        return company;
    }
    @Override
    public void deleteById(String id) {
        iCompanyDao.deleteById(id);
    }

    @Override
    public void saveCompany(Company company) {
        String id = UUID.randomUUID().toString();
        company.setId(id);
        iCompanyDao.save(company);
    }
}