package cn.htl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestZtreeDataController extends BaseController {

    @RequestMapping(path="/getZtreeData",method ={ RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Object getZtreeData(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> node1=new HashMap<String,Object>();
        node1.put("id",1);
        node1.put("pId",0);
        node1.put("name","Sass管理");
        node1.put("open",true);

        Map<String,Object> node2=new HashMap<String,Object>();
        node2.put("id",11);
        node2.put("pId",1);
        node2.put("name","企业管理");
        node2.put("open",true);
        node2.put("checked",true);

        Map<String,Object> node3=new HashMap<String,Object>();
        node3.put("id",111);
        node3.put("pId",1);
        node3.put("name","模块管理");

        //因为三个元素放在[]中，所以本质上放到集合中的
        list.add(node1);
        list.add(node2);
        list.add(node3);
        return list; //list虽然是对象，但会被 @ResponseBody转成json
    }
}
