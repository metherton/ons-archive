<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
<c:choose>
    <c:when test="${tree.new}">
        <c:set var="method" value="post" />
        New
    </c:when>
    <c:otherwise>
        <c:set var="method" value="put" />
        Edit
    </c:otherwise>
</c:choose>
Tree
    </div>
    <div class="innercontentmiddlebody">
<form:form modelAttribute="tree" method="${method}">

    <p class="container">
    <form:label class="form-label" cssErrorClass="form-label errors" path="description">Description</form:label>
    <form:textarea rows="30" columns="180" class="input-textarea" path="description" />
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
        <c:choose>
            <c:when test="${tree.new}">
                <input id="submit" type="submit" value="Add Tree Root Ancestor" />
            </c:when>
            <c:otherwise>
                <input id="submit" type="submit" value="Edit Tree Root Ancestor" />
            </c:otherwise>
        </c:choose>
    </p>

</form:form>
    </div>
</div>