<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%--<%@ taglib prefix="gedcomContents" uri="gedcomContents" %>--%>

<form:form modelAttribute="viewgedcomform" name="myform"  method="POST">
    <form:select path="gedcomIndividual">
        <form:option value="" label="--Please Select"/>
        <form:options items="${individuals}" itemValue="id" itemLabel="fullDetails" />
    </form:select>

<br />
<form:select path="tree"  onchange="document.myform.submit()">
    <form:option value="" label="--Please Select"/>
    <form:options items="${trees}" itemValue="id" itemLabel="description" />
</form:select>
<br />
<%--<input type="radio" <c:if test="${disabled}">disabled</c:if> name="relation" value="parent">Parent&nbsp;<input type="radio" name="relation" value="child">Child&nbsp;<input type="radio" name="relation" value="sibling">Sibling--%>
<br />
<%--<select name="person" <c:if test="${disabled}">disabled</c:if> >--%>
    <%--<option value="">Please select a person to merge with</option>--%>
    <%--<gedcomContents:person persons="${persons}">--%>
        <%--<option id=${person.id} value="${person.id}">${person.fullname}&nbsp;${person.birthDate}&nbsp;${person.address}</option>--%>
    <%--</gedcomContents:person>--%>
<%--</select>--%>
<br />
<input type="submit" />
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>