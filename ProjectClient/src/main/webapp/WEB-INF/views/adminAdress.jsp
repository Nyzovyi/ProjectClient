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
	<a href="/admin/client">Client Panel</a>
	<form:form action="/admin/adress" method="post" modelAttribute="adress">
		<form:input path="id" type="hidden"/>
				<table>
				
						<form:select path="street" items="${streets}" itemLabel="name" itemValue="id">
						
						</form:select>
						
					<tr>
						<td><form:errors path="namberHouse"/></td>
					</tr>
					<tr>
						<td><form:input path="namberHouse"/></td>
					</tr>
					<tr>
						<td><input type="submit"></td>
					</tr>
					
				</table>
	</form:form>
	<table>
		<tr>
			<th>Adress namber</th>
		</tr>
		<c:forEach items="${adresss.content}" var="adress">
			<tr>
				<td>${adress.namberHouse}</td>
				<td>
					<a href="/admin/adress/delete/${adress.id}">delete</a>
				</td>
				<td>
					<a href="/admin/adress/update/${adress.id}">update</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<c:if test="${adresss.number ne 0}">
					<a href="/admin/country?page=${adresss.number}&size=${adresss.size}">previous</a>
				</c:if>
			</td>
			<td>
				<c:if test="${adresss.number ne adresss.totalPages}">
					<a href="/admin/country?page=${adresss.number+2}&size=${adresss.size}">next</a>
				</c:if>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/admin/adress?page=1&size=1">1</a></td>
			<td><a href="/admin/adress?page=1&size=5">5</a></td>
			<td><a href="/admin/adress?page=1&size=10">10</a></td>
			<td><a href="/admin/adress?page=1&size=20">20</a></td>
		</tr>
	</table>
</html>