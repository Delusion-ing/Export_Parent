<%--
  Created by IntelliJ IDEA.
  User: 胡靖
  Date: 2020/10/26
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<div class="pull-left">
    <div class="form-group form-inline">
        总共${pi.pages} 页，共${pi.total} 条数据。
    </div>
</div>

<div class="box-tools pull-right">
    <ul class="pagination" style="margin: 0px;">
        <li >
            <a href="javascript:goPage(1)" aria-label="Previous">首页</a>
        </li>
        <c:if test="${pi.pageNum != 1 }">
            <li><a href="javascript:goPage(${pi.prePage})">上一页</a></li>
        </c:if>
        <c:forEach begin="1" end="${pi.pages}" var="i">
            <li class="paginate_button ${pi.pageNum==i ? 'active':''}"><a href="javascript:goPage(${i})">${i}</a></li>
        </c:forEach>
        <c:if test="${pi.pageNum != pi.pages }">
            <li><a href="javascript:goPage(${pi.nextPage})">下一页</a></li>
        </c:if>

        <li>
            <a href="javascript:goPage(${pi.pages})" aria-label="Next">尾页</a>
        </li>
    </ul>
</div>
<form id="pageForm" action="${param.pageUrl}" method="post">
    <input type="hidden" name="curr" id="curr">
    <input type="hidden" name="pageSize" id="pageSize">
</form>
<script>
    function goPage(page) {
        <%--document.getElementById("curr").value = page //curr=2--%>
        <%--document.getElementById("pageSize").value = ${pi.pageSize} //pageSize=3--%>
        <%--document.getElementById("pageForm").submit()--%>
        window.location = '${param.pageUrl}?curr='+page+'&pageSize='+${pi.pageSize}
    }
</script>
</body>
</html>



