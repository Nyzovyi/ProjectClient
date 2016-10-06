<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	form#filter span{
		display: inline-block;
		width: 100%;
	}
	form#filter label{
		vertical-align: super;
		padding-left: 2%;		
	}
</style>
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>Client panel</th>
	</tr>
</table>

<div class="row-fluid">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="">
							<ul class="nav navbar-nav">
								<li><a href="/admin/name">Name Panel</a></li>
								<li><a href="/admin/country">Country Panel</a></li>
							</ul>
						</div>
					</div>
				</nav>
</div>

<form:form action="/admin/client" method="post" modelAttribute="client">
		<form:hidden path="id"/>
			<table>
					<tr>
						<td><form:errors path="lastName" /></td>
					</tr>
					<tr>
						<td><form:input path="lastName" placeholder="LastName"	/></td>
					</tr>
					
					<tr>
						<td>
							<form:select path="name">
								<c:forEach items="${names}" var="name">
									<c:choose>
										<c:when test="${name.id eq name.id}">
											<option value="${name.id}" selected="selected">${name.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${name.id}">${name.name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
						</td>
					</tr>
					<%-- <tr>
						<td><form:input path="name" placeholder="name" /></td>
					</tr> --%>
					
					<tr>
						<td><form:errors path="surname" /></td>
					</tr>
					<tr>
						<td><form:input path="surname" placeholder="Surname" /></td>
					</tr>
					
					<tr>
						<td><form:errors path="adress" /></td>
					</tr>
					
					
					
				<%-- 	<tr>
						<td>
							<form:select path="adress" >
							<c:forEach items="${adresss}" var="adress">
								<c:choose>
									<c:when test="${client.adress.id eq adress.id}">
										<option value="${adress.id}" selected="selected">${adress.namberHouse}</option>
									</c:when>
									<c:otherwise>
										<option value="${adress.id}">${adress.namberHouse}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</td>
					</tr> --%>
					
					<tr>
						<td><form:errors path="dateOfBirth" /></td>
					</tr>
					<tr>
						<td><form:input path="dateOfBirth" placeholder="dateOfBirth" /></td>
					</tr>
					
					<tr>
						<td><form:errors path="phone" /></td>
					</tr>
					<tr>
						<td><form:input path="phone" placeholder="phone" /></td>
					</tr>
					
					<tr>
						<td><input type="submit"></td>
					</tr>
			</table>
</form:form>		
</body>
<div class="col-md-12">
	<div class="col-md-6">Client Name</div>
	<c:forEach items="${clients}" var="client">
		<div class="col-md-12">
			<div class="col-md-2">${client.name}</div>
			<div class="col-md-4"><img
				src="/images/client/${client.id}${client.path}?version=${client.version}"
				class="img-thumbnail" width="127" /></div>
			<div class="col-md-2"><a href="/admin/client/delete/${client.id}">delete  </a></div>
			<div class="col-md-2"><a href="/admin/client/update/${client.id}">update</a></div>
			<div class="col-md-2"><a href="/admin/client/${client.id}">add client</a></div>
		</div>
	</c:forEach>
</div>
<div class="row-fluid">
	<div class="col-md-3">
		<form:form action="/admin/country" class="form-inline" method="get" modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search"/>
				<div class="form-group">
					<form:input path="search" placeholder="search" class="form-control" />
					<button type="submit" class="btn btn-primary">Ok</button>
				</div>
		</form:form>
	</div>
</div>

<form:form action="/admin/client" method="post"
		modelAttribute="client">
		<form:hidden path="id" />
	<table>
			<tr>
				<td><form:select path="name">
						<c:forEach items="${names}" var="name">
							<c:choose>
								<c:when test="${name.id eq name.id}">
									<option value="${name.id}" selected="selected">${name.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${name.id}">${name.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
				<td><form:select path="adress">
						<c:forEach items="${adresss}" var="adress">
							<c:choose>
								<c:when test="${client.adress.id eq adress.id}">
									<option value="${adress.id}" selected="selected">${adress.namberHouse}, ${street.name}, ${city.name}, ${region.name}, ${country.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${adress.id}">${adress.namberHouse}, ${street.name}, ${city.name}, ${region.name}, ${country.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
	</table>
</form:form>
<table>
		<tr>
			<th>Last Name</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Adress</th>
			<th>Date Of Birth</th>
			<th>Phone</th>
		</tr>
		<c:forEach items="${clients}" var="client">
			<tr>
				<td>${client.surname}</td>
				<td>${client.name.name}</td>
				<td>${client.surname}</td>
				<td>${client.adress.street.city.region.country.name}</td>
				<td>${client.dateOfBirth}</td>
				<td>${client.phone}</td>
				<td><a
					href="/admin/client/delete/${client.id}">delete</a>
				</td>
				<td><a
					href="/admin/client/update/${client.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</html>