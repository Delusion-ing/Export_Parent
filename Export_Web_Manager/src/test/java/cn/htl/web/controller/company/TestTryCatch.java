package cn.htl.web.controller.company;

import org.junit.Test;

/**
 * @ClassName TestTryCatch
 * @Description TODO
 * @Author 胡靖
 * @Date 2020/10/26 19:25
 * @Version 1.0
 */
public class TestTryCatch {
    @Test
    public void test01(){
        try{
            int num = 0;
            System.out.println("hello");//1
            System.out.println(1/num);
            System.out.println("world");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
