<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/04/2026
  Time: 7:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<table border="1" cellpadding="10" cellspacing="10">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Chuc vu</th>
    <th>Luong</th>
    <th>Dang gia</th>
  </tr>
  </thead>
  <tbody>
  <th>
    <c:forEach items="${employee_list}" var="e">

    <tr>
  <td><c:out value="${e.id}"/></td>
  <td><c:out value="${e.fullName}"/></td>
  <td><c:out value="${e.department}"/></td>
  <td><c:out value="${e.salary}"/></td>

  <c:if test="${e.salary >=1000}">
    <td><c:out value="Muc luong cao"/></td>
  </c:if>
  <c:if test="${e.salary <1000}">
    <td><c:out value="Muc luong co ban"/></td>
  </c:if>

  </tr>

  </c:forEach>
  </th>
  </tbody>
</table>

</body>
</html>