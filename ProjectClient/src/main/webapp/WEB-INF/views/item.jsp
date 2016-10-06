<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" action="some/item/save" modelAttribute="item">
	<form:input path="name"/>
	<c:forEach items="${stringProperties}" var="stringProperty">
		<form:select path="stringValues" 
		items="${stringProperty.stringValues}"
		itemLabel="name"
		itemValue="id">
		</form:select>
	</c:forEach>
	<c:forEach items="${digitProperties}" var="digitProperty" varStatus="vs">
		<form:hidden path="digitValues['${vs.index}'].digitProperty"/>
		<form:input path="digitValues['${vs.index}'].value"/>
	</c:forEach>
</form:form>