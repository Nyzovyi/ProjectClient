<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/admin/name" method="post" modelAttribute="name">
		<form:input path="id" type="hidden"/>
		<table>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach items="${names}" var="name">
			<tr>
				<td>${name.name}</td>
				<td>
					<a href="/admin/name/delete/${name.id}">delete</a>
				</td>
				<td>
					<a href="/admin/name/update/${name.id}">update</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${countries.number ne 0}">
					<a href="/admin/name?page=${countries.number}&size=${countries.size}"> previous </a>
				</c:if>
			</td>
			<td>
				<c:if test="${countries.number ne countries.totalPages-1}">
					<a href="/admin/name?page=${countries.number+2}&size=${countries.size}"> next </a>
				</c:if>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/name?page=1&size=1">1</a></td>
			<td><a href="/admin/name?page=1&size=5">5</a></td>
			<td><a href="/admin/name?page=1&size=10">10</a></td>
			<td><a href="/admin/name?page=1&size=20">20</a></td>
		</tr>
	</table>
</body>
</html>