<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP List Employee Records</title>
</head>
<body>
	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/attendance" user="root" password="root" />

	<sql:query var="listreg" dataSource="${myDS}">
select * from register;
</sql:query>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Student List</h2>
			</caption>
			<tr>
				<th>firstname</th>
				<th>lastname</th>
				<th>gender</th>
				<th>email</th>
				<th>mobile</th>
				<th>password</th>
				<!-- <th>id</th> -->
				<!-- <th>Date of joining</th>
<th>City</th>
<th>Department No</th> -->
			</tr>
			<c:forEach var="regobj" items="${listreg.rows}">
				<tr>
					<td><c:out value="${regobj.FirstName}" /></td>
					<td><c:out value="${regobj.LastName}" /></td>
					<td><c:out value="${regobj.Gender}" /></td>
					<td><c:out value="${regobj.Email}" /></td>
					<td><c:out value="${regobj.Mobile}" /></td>
					<td><c:out value="${regobj.Password}" /></td>
					<%-- <td><c:out value="${regobj.Id}" /></td> --%>
				
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>