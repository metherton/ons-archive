<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form:form modelAttribute="surname" method="POST">

    <form:label path="name">Surname</form:label>
    <form:input path="name" />
    <form:errors path="name" cssClass="errors" />


    <input type="submit" id="submit"    value="Add Surname" />
</form:form>
