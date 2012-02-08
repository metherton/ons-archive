<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<form:form modelAttribute="surname" method="POST">

    <form:label path="name">Surname</form:label>
    <form:input path="name" />
    <form:errors path="name" cssClass="errors" />


    <input type="submit" id="submit"    value="Add Surname" />
</form:form>
