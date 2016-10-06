<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/admin/adress">Adress Panel</a>
	<form:form action="/admin/street" method="post" modelAttribute="street">
		<form:input path="id" type="hidden"/>
		<table>
		
			<form:select path="city" items="${citys}" itemLabel="name" itemValue="id">
			</form:select>
		
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
			<th>Street name</th>
		</tr>
		<c:forEach items="${streets.content}" var="street">
			<tr>
				<td>${street.name}</td>
				<td>
					<a href="/admin/street/delete/${street.id}">delete</a>
				</td>
				<td>
					<a href="/admin/street/update/${street.id}">update</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${streets.number ne 0}">
					<a href="/admin/street?page=${streets.number}&size=${streets.size}">previous</a>
				</c:if>
			</td>
			<td>
				<c:if test="${streets.number ne streets.totalPages-1}">
					<a href="/admin/street?page=${streets.number+2}&size=${streets.size}">next</a>
				</c:if>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/street?page=1&size=1">1</a></td>
			<td><a href="/admin/street?page=1&size=5">5</a></td>
			<td><a href="/admin/street?page=1&size=10">10</a></td>
			<td><a href="/admin/street?page=1&size=20">20</a></td>
		</tr>
	</table>
</html>