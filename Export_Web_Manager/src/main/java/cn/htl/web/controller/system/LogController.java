package cn.htl.web.controller.system;

import cn.htl.domain.system.log.Log;
import cn.htl.service.system.log.ILogService;
import cn.htl.web.controller.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/5 17:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin/log")
public class LogController extends BaseController {

    @Autowired
    ILogService logService;



    @RequestMapping(path = "/toList", method = {RequestMethod.GET, RequestMethod.POST})
    public String toList(@RequestParam(defaultValue = "1") int curr, @RequestParam(defaultValue = "5") int pageSize) {
        //调查询分页列表的方法
        PageInfo<Log> pi = logService.findByPage(curr, pageSize, getLoginCompanyId());
        //将pi添加到页面
        request.setAttribute("pi", pi);
        return "system/log/log-list";
    }

}
