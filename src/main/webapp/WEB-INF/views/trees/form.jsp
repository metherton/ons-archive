<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
