<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form:form modelAttribute="person" method="POST">

    <form:label path="firstName">First Name</form:label>
    <form:input path="firstName" />
    <form:errors path="firstName" cssClass="errors" />

    <form:label path="surname">Surname</form:label>
    <form:select path="surname">
        <form:option value="" label="--Please Select"/>
        <form:options items="${surnames}" itemValue="id" itemLabel="name" />
    </form:select>
    <form:errors path="surname" cssClass="errors" />

    <form:label path="father">Father</form:label>
    <form:select path="father">
        <form:option value="15" label="--Please Select"/>
        <form:options items="${fathers}" itemValue="id" itemLabel="fullname" />
    </form:select>
    <form:errors path="father" cssClass="errors" />

    <form:label path="mother">Mother</form:label>
    <form:select path="mother">
        <form:option value="15" label="--Please Select"/>
        <form:options items="${mothers}" itemValue="id" itemLabel="fullname" />
    </form:select>
    <form:errors path="mother" cssClass="errors" />

    <form:label path="gender">Gender</form:label>
    <form:radiobuttons path="gender" items="${genderOptions}" />
    <form:errors path="gender" cssClass="errors" />

    <input type="submit" id="submit"    value="Add Person" />
</form:form>
