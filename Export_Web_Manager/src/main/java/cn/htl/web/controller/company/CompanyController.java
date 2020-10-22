package cn.htl.web.controller.company;

import cn.htl.domain.company.Company;
import cn.htl.service.company.ICompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private static final Logger l = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    ICompanyService iCompanyService;

    //list.action -> list
    @RequestMapping(path="/list.do",method = RequestMethod.GET)
    public String list(Model model){
        List<Company> list = iCompanyService.findAll();
        //打印重要数据
        l.info("list  list="+list);
        model.addAttribute("list",list);
        return "company/company-list";
    }
}