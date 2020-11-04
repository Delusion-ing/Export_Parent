<%--
  Created by IntelliJ IDEA.
  User: 胡靖
  Date: 2020/11/3
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>

<%@  page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <% pageContext.setAttribute("path",request.getContextPath()); %>
    <%-- 第一步：拷贝如下引入的css/js文件到项目的ztree-test.html页面
     第二步：拷贝js导入到当前页面
     第三步：页面定义显示树的区域--%>
    <link rel="stylesheet" type="text/css" href="${path}/plugins/ztree/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="${path}/plugins/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${path}/plugins/ztree/js/jquery.ztree.all-3.5.min.js"></script>
    <script type="text/javascript">


        //当前的配置信息
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        //当前的数据
        /*var zNodes =[
            { id:1, pId:0, name:"Sass管理", open:true},
            { id:11, pId:1, name:"企业管理", open:true,checked:true},
            { id:111, pId:1, name:"模块管理"}
        ];*/

        $(document).ready(function(){
            var fn =function(data){
                //菜单的初始化
                $.fn.zTree.init($("#treeDemo"), setting, data);
                //参1 显示的标签
                //参2 设置的参数 比如支持复选 check enable = true
                //参3 数据
            }
            $.get('${path}/test/getZtreeData.do',fn,'json')


        });

    </script>
</head>
<body>
<!-- 标签 -->
<ul id="treeDemo" class="ztree"></ul>
</body>
</html>
