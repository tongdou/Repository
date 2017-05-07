<%--
  Created by IntelliJ IDEA.
  User: shenyuzhu
  Date: 17/2/1
  Time: 下午5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<c:if test="${!empty error}">
    <div style="color: blue"><c:out value="${error}"></c:out></div>
</c:if>
<form action="<c:out value="/loginCheck.html"/>" method="post">
    用户名:
    <input name="userName" type="text"/>
    <br/>
    密码:
    <input name="password" type="password"/>
    <br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
