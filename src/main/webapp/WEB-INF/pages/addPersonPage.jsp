<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HH
  Date: 2018/8/3
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>11</p>
    <ul>
        <c:forEach var="error" items="${allErrors}">
            <li>${error.defaultMessage}</li>
        </c:forEach>
    </ul>

    <form action="savePerson">
        姓名：<input type="text" name="name"><br>
        地址：<input type="text" name="address"><br>
        联系电话：<input type="text" name="phone"><br>
        生日：<input type="date" name="birthday"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
