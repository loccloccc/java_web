<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2026
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>
  Xin chào, ${sessionScope.loggedUser}!
  Vai trò: ${sessionScope.role}
</h2>

<a href="logout">Đăng xuất</a>

<hr/>

<table border="1">
  <tr>
    <th>Mã đơn</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>

  <c:forEach var="o" items="${orders}">
    <tr>
      <td>${o.id}</td>
      <td>${o.product}</td>

      <td>
        <fmt:formatNumber value="${o.total}" type="currency" currencySymbol="₫"/>
      </td>

      <td>
        <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy"/>
      </td>
    </tr>
  </c:forEach>
</table>

<hr/>

<h3>
  Tổng lượt xem đơn hàng toàn hệ thống:
  ${applicationScope.totalViewCount}
</h3>
</body>
</html>