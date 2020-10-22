package cn.htl.service.company.impl;

import cn.htl.dao.company.ICompanyDao;
import cn.htl.domain.company.Company;
import cn.htl.service.company.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //如果service的实现类需要由spring创建，则打上注解 @Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    ICompanyDao iCompanyDao;
    public List<Company> findAll() {//service要调用dao查询数据，所以要注入
        return iCompanyDao.findAll();
    }
}