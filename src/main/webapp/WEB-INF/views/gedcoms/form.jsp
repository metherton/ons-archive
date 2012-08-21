<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
<c:choose>
    <c:when test="${gedcom.new}">
        <c:set var="method" value="post" />
        New
    </c:when>
    <c:otherwise>
        <c:set var="method" value="put" />
        Edit
    </c:otherwise>
</c:choose>
Gedcom
    </div>
    <div class="innercontentmiddlebody">
<form:form modelAttribute="gedcom" method="${method}" enctype="multipart/form-data" >
    <%--<form:form modelAttribute="gedcom" method="${method}"  >--%>

    <p class="container">
        <form:label class="form-label" path="title"  cssErrorClass="form-label errors">First Name</form:label>
        <form:input class="input-text" path="title" />
        <form:errors path="title" cssClass="errors" />
    </p>

    <input name="gedcomfile" type="file"/>

    <p class="container">
        <input id="submit" type="submit" value="Submit" />
    </p>

</form:form>
    </div>
</div>