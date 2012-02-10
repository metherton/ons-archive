<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<form:form modelAttribute="tree" method="POST">

    <p class="container">
    <form:label class="form-label" cssErrorClass="form-label errors" path="description">Description</form:label>
    <form:input class="input-text" path="description" />
    <form:errors path="description" cssClass="errors" />
    </p>

    <p class="container">
    <form:label class="form-label"  cssErrorClass="form-label errors" path="person">Person</form:label>
    <form:select class="input-select" path="person">
        <form:option value="" label="--Please Select"/>
        <form:options items="${persons}" itemValue="id" itemLabel="fullname" />
    </form:select>
    <form:errors path="person" cssClass="errors" />
    </p>

    <p class="container">
    <input type="submit" id="submit"    value="Add Tree Root Ancestor" />
    </p>

</form:form>
