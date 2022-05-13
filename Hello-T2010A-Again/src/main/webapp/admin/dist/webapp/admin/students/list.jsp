<%@ page import="com.t2010a.hellot2010aagain.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Tran Duong
  Date: 12-May-22
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> listStudent = (List<Student>)request.getAttribute("listStudent");
%>
<html>
<head>
    <title>List student</title>
</head>
<body>
<h1>List student</h1>
<ul>
    <%        for (Student st: listStudent ) {
    %>
        <li><%=st.getRollNumber()%> - <%=st.getFullName()%></li>
    <%}%>
</ul>
</body>
</html>
