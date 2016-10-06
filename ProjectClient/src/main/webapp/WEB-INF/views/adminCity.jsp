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
	<a href="/admin/street">Street Panel</a>
	<form:form action="/admin/city" method="post" modelAttribute="city">
		<form:input path="id" type="hidden"/>
		<table>
		
				<form:select path="region" items="${regions}" itemLabel="name" itemValue="id">
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
			<th>City name</th>
		</tr>
		<c:forEach items="${citys.content}" var="city">
			<tr>
				<td>${city.name}</td>
				<td>
					<a href="/admin/city/delete/${city.id}">delete</a>
				</td>
				<td>
					<a href="/admin/city/update/${city.id}">update</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${citys.number ne 0}">
					<a href="/admin/city?page=${citys.number}&size=${citys.size}">previous</a>
				</c:if>
			</td>
			<td>
				<c:if test="${citys.number ne citys.totalPages-1}">
					<a href="/admin/city?page=${citys.number+2}&size=${citys.size}">next</a>
				</c:if>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/city?page=1&size=1">1</a></td>
			<td><a href="/admin/city?page=1&size=5">5</a></td>
			<td><a href="/admin/city?page=1&size=10">10</a></td>
			<td><a href="/admin/city?page=1&size=20">20</a></td>
		</tr>
	</table>
</html>