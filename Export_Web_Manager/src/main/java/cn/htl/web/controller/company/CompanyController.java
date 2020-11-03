package cn.htl.web.controller.company;

import cn.htl.domain.company.Company;
import cn.htl.service.company.ICompanyService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/company")
public class CompanyController {
    private static final Logger l = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    ICompanyService iCompanyService;

    @RequestMapping(path="/toList",method={RequestMethod.GET,RequestMethod.POST})
    public String toList( Integer curr, Integer pageSize, Model model){
        //调service获取数据
        if (curr == null) {
            curr = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        PageInfo<Company> pi = iCompanyService.findPage(curr,pageSize);
        l.info("toList pi="+pi);
        model.addAttribute("pi",pi);
        //将数据发到页面，使用标签
        return "company/company-list";
    }
    @RequestMapping(path="/update",method = {RequestMethod.GET,RequestMethod.POST})
    public String update(Company company){
        l.info("update company="+company);

        iCompanyService.updateCompany(company);

        return "redirect:/admin/company/toList.do";//跳转到列表页面
    }
    //${path}/company/toEdit.do?id=${item.id}

    @RequestMapping(path="/toEdit",method = RequestMethod.GET)
    public String toEdit(String id,Model model){
        l.info("toEdit id="+id);
        Company company=iCompanyService.findById(id);
        l.info("toEdit company="+company);

        model.addAttribute("company",company);
        return "company/company-update";
    }
    //${path}/company/delete.do?id="+id
    @RequestMapping(path="/delete",method = RequestMethod.GET)
    public String delete(String id){
        l.info("delete id="+id);
        iCompanyService.deleteById(id);
        return "redirect:/admin/company/toList.do";//跳转到列表页面
    }
    @RequestMapping(path = "/toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "company/company-add";
    }
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String add(Company company){
        iCompanyService.saveCompany(company);
        return "redirect:/admin/company/toList.do";
    }

}