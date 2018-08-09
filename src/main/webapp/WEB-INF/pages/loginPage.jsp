 <%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/7/9
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>临床医生助手</title>
    <!--
  <body>

  <form action="LoginServlet">
    用户名：<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
  </form>
  </body>
</html>

-->
        <style>
            Body{
                width:100%;
                height:100%;
                background-color:#4A374A;


            }
            #login
            {
                position:absolute;
                top:20%;
                left:39%;

            }

            h1{
                font-size:25px;
                text-align:center;
                color:#fff;
                font-family: "Microsoft YaHei UI ";
            }
            input
            {
                width:400px;
                height:50px;
                outline:10px;
                padding:5px;
                margin:3px;
                border-style:hidden;
                font-size:15px;
                color:#fff;
                background-color:#000000;
                border-radius: 15px;
            }
            .submit{
                width:400px;
                height:50px;
                outline:10px;
                padding:5px;
                margin:3px;
                border-style:hidden;
                font-size:15px;

                border-radius: 17px;
                color:#4A77D4;
                background-color:#500000;
            }
            .submit {
                cursor:pointer;
                display:inline-block;
                position:relative;
                transition:0.5s;
            }
            .submit:after {
                content: '>>';
                position: absolute;
                opacity: 0;
                top: 0;
                right: -20px;
                transition: 0.5s;
            }

            .submit:hover{
                padding-right: 50px;
            }

            .submit:hover :after {
                opacity: 1;
                right: 0;
            }

        </style>

    </head>
<body>

<div id=login>
    <p>${msg}</p>
    <h1>Login</h1>
    <form  name="checkInf" action="personLogin" onsubmit=" validateInf()" method="post">

        <input type="text" name="username" id="username" placeholder="用户名"><br>
        <input type="password" name="password" id="password" placeholder="密码"><br>
        <input type="submit" name="submit" class="submit" value="login"  color="F44336" >

    </form>
</div>

<%--<script>--%>

    <%--function validateInf() {--%>
        <%--var username = document.getElementById("username");--%>
        <%--var password = document.getElementById("password");--%>
        <%--if (username.value == "") {--%>
            <%--alert("请输入姓名");--%>
        <%--}--%>

        <%--else if (password.value == "") {--%>
            <%--alert("请输入密码");--%>
        <%--}--%>



    <%--}--%>


<%--</script>--%>
</body>


</html>

