<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2018/8/3
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="searchByPersonName">
    姓名<input type="text" name="search_name">
    <input type="submit" value="查询"><br>
    </form>
    <a href="addPerson"><input type="button" value="增加"></a>
    <table border="1">
        <tr>
            <td>姓名</td><td>地址</td><td>联系电话</td><td>生日</td><td>操作</td>
        </tr>
        <c:forEach var="person" items="${list}">
            <tr>
                <td>${person.name}</td>
                <td>${person.address}</td>
                <td>${person.phone}</td>
                <td><fmt:formatDate value="${person.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="toEditPerson?id=${person.id}"><input type="button" value="修改"></a>
                    <a href="deletePerson?id=${person.id}"><input type="button" value="删除"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        第${page.currentPage}页 共${page.totalPage}页
        <a href="listPersonByPage?currentPage=1">[首页]</a>
        <c:choose>
            <c:when test="${page.currentPage gt 1}">
                <a href="listPersonByPage?currentPage=${page.currentPage-1}">[上页]</a>
            </c:when>
            <c:otherwise>
                <a href="javaScript:alert('已经是第一页了！');">[上页]</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.currentPage lt page.totalPage}">
                <a href="listPersonByPage?currentPage=${page.currentPage+1}">[下页]</a>
            </c:when>
            <c:otherwise>
                <a href="javaScript:alert('已经最后一页了！');">[下页]</a>
            </c:otherwise>
        </c:choose>
        <a href="listPersonByPage?currentPage=${page.totalPage}">[末页]</a>
    </div>
</body>
</html>
