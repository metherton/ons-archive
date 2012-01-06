<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form:form modelAttribute="person" method="POST">
    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName" />


    <form:select path="surname">
        <form:option value="" label="--Please Select"/>
        <form:options items="${surnames}" itemValue="id" itemLabel="name" />
    </form:select>


    <input type="submit" id="submit"    value="Update Person" />
</form:form>
