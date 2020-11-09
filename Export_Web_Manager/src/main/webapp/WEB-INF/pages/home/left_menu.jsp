<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../base.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${path}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p> ${loginUser.userName}</p>
                <a href="#">${loginUser.companyName}</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <c:forEach items="${sessionScope.menus}" var="item">
                <c:if test="${item.ctype==0}">
                    <li class="treeview">
                            <%--一级菜单 --%>
                        <a href="#">
                            <i class="fa fa-cube"></i> <span>${item.name}</span>
                            <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                        </a>
                        <ul class="treeview-menu">
                            <c:forEach items="${sessionScope.menus}" var="item2">
                                <%--           一级菜单的ctype==0 二级菜单的ctype==1--%>
                                <%--           二级的parentId肯定与一级的moduleId是相等，才能显示在该菜单下面--%>
                                <c:if test="${item2.ctype==1 && item2.parentId == item.moduleId}">
                                    <%--  二级菜单 --%>
                                    <li id="${item2.moduleId}">
                                        <!-- 此处的链接 先加项目地址再加数据库中的curl-->
                                        <a onclick="setSidebarActive(this)" href="${path}/${item2.curl}"
                                           target="iframe">
                                            <i class="fa fa-circle-o"></i>${item2.name}
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:if>
            </c:forEach>
            <!--Ctrl+Alt+L整理代码格式的作用 -->

        </ul>

    </section>
    <!-- /.sidebar -->
</aside>
