<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<form:form modelAttribute="tree" method="POST">

    <form:label path="description">Description</form:label>
    <form:input path="description" />
    <form:errors path="description" cssClass="errors" />

    <form:label path="person">Person</form:label>
    <form:select path="person">
        <form:option value="" label="--Please Select"/>
        <form:options items="${persons}" itemValue="id" itemLabel="fullname" />
    </form:select>
    <form:errors path="person" cssClass="errors" />

    <input type="submit" id="submit"    value="Add Tree Root Ancestor" />
</form:form>
