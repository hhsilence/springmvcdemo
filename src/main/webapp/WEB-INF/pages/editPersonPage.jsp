<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2018/8/3
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
    <ul>
         <c:forEach var="error" items="${allErrors}">
             <li>${error.defaultMessage}</li>
          </c:forEach>
    </ul>
    <form action="editPerson">
        <input type="hidden" name="id" value="${person.id}"><br>
        姓名：<input type="text" name="name" value="${person.name}"><br>
        地址：<input type="text" name="address" value="${person.address}"><br>
        联系电话：<input type="text" name="phone" value="${person.phone}"><br>
        生日：<input type="date" name="birthday" value="${person.birthday}"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
