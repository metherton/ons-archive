<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<form:form modelAttribute="surname" method="POST">

    <p class="container">
    <form:label class="form-label" cssErrorClass="form-label errors" path="name">Surname</form:label>
    <form:input class="input-text" path="name" />
    <form:errors path="name" cssClass="errors" />
    </p>

    <input type="submit" id="submit"    value="Add Surname" />
</form:form>
