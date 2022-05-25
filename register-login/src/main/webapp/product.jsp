<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.t2010a.registerlogin.entity.Account" %>
<%--
  Created by IntelliJ IDEA.
  User: Tran Duong
  Date: 24-May-22
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%
Account currentLogin = (Account) session.getAttribute("currentLogin");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="header__top__links">
    <%
        if(currentLogin != null){
    %>
    <a href="/profile"><%= currentLogin.getUsername()%></a>
    <a href="/logout">(Logout)</a>
    <%}else{%>
    <a href="/login">Log In</a>
    <%}%>
    <a href="#">FAQs</a>
</div>
</body>
</html>
