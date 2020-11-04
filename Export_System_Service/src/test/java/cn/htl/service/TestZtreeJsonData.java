package cn.htl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestZtreeJsonData {
    @Test
    public void test01() throws JsonProcessingException {
      /*  [
        { id:1, pId:0, name:"Sass管理", open:true},
        { id:11, pId:1, name:"企业管理", open:true,checked:true},
        { id:111, pId:1, name:"模块管理"}
        ];
        []表示List    所以类型List<元素类型>
        由于[]内的元素的字段不一致，只有Map才行 元素类型为  Map<String,Object>

        List<Map<String,Object>>
        */
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

        String json = new ObjectMapper().writeValueAsString(list);
        System.out.println(json);
    }
}