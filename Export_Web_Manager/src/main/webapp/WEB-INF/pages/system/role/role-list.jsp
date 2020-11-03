<%--
  Created by IntelliJ IDEA.
  User: 胡靖
  Date: 2020/10/31
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../base.jsp"%>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 页面meta /-->

</head>
<script>
    function deleteById() {
        var id = getCheckId()
        if(id) {
            if(confirm("你确认要删除此条记录吗？")) {
                // location.href="/system/role/delete.do?id="+id;
                //使用ajax请求
                var url= '${path}/admin/role/delete.do?roleId='+id;
                var fn = function(result){ //{code:200,msg:'删除成功',data:null}

                    alert(id)
                    //弹出提示
                    alert(result.msg)
                    window.location.reload() //重新加载
                }
                $.get(url,fn,'json')
            }
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }

    function findModuleByRoleId(){
        var id = getCheckId();
        if(id) {
            location.href="/admin/role/roleModule.do?roleid="+id;
        }else{
            alert("请勾选待处理的记录，且每次只能勾选一个")
        }
    }
</script>
<body>
<div id="frameContent" class="content-wrapper" style="margin-left:0px;">
    <section class="content-header">
        <h1>
            系统管理
            <small>角色管理</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!-- .box-body -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">角色列表</h3>
            </div>

            <div class="box-body">

                <!-- 数据表格 -->
                <div class="table-box">

                    <!--工具栏-->
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" title="新建" onclick='location.href="${path}/admin/role/toAdd.do"'><i class="fa fa-file-o"></i> 新建</button>
                                <button type="button" class="btn btn-default" title="删除" onclick='deleteById()'><i class="fa fa-trash-o"></i> 删除</button>
                                <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                <button type="button" class="btn btn-default" title="权限" onclick="findModuleByRoleId()"><i class="fa fa-users"></i> 权限</button>
                            </div>
                        </div>
                    </div>
                    <div class="box-tools pull-right">
                        <div class="has-feedback">
                            <input type="text" class="form-control input-sm" placeholder="搜索">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </div>
                    <!--工具栏/-->

                    <!--数据列表-->
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>
                            <th class="" style="padding-right:0px;">
                                <input type="checkbox" name="selid" onclick="checkAll('id',this)">
                            </th>
                            <th class="sorting">序号</th>
                            <th class="sorting">编号</th>
                            <th class="sorting">名称</th>
                            <th class="sorting">说明</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pi.list}" var="o" varStatus="status">
                            <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
                                <td><input type="checkbox" name="roleId" value="${o.roleId}"/></td>
                                <td>${status.index+1}</td>
                                <td>${o.roleId}</td>
                                <td><a href="${path}/admin/role/toUpdate.do?roleId=${o.roleId}">${o.name}</a></td>
                                <td>${o.remark}</td>
                                <th class="text-center"><button type="button" class="btn bg-olive btn-xs" onclick='location.href="${path}/admin/role/toUpdate.do?roleId=${o.roleId}"'>编辑</button></th>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box-footer">
                <jsp:include page="../../common/page.jsp">
                    <jsp:param value="${path}/admin/role/toList.do" name="pageUrl"/>
                </jsp:include>
            </div>
        </div>

    </section>
</div>
</body>

</html>
