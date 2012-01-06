<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="firstName">${person.firstName}</div>
<div id="surname">${person.surname.name}</div>
<div id="father">${person.father.firstName} ${person.father.surname.name}</div>
<div id="mother">${person.mother.firstName} ${person.mother.surname.name}</div>
