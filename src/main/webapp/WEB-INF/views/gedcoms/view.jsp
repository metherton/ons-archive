<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

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

<form:radiobuttons path="relation" items="${relationOptions}" />

<br />
    <form:select path="person">
        <form:option value="" label="--Please Select"/>
        <form:options items="${persons}" itemValue="id" itemLabel="fullname" />
    </form:select>

<br />
<input type="submit" />
</form:form>
<%@ include file="/WEB-INF/views/footer.jsp" %>