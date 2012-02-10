<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
    <c:choose>
        <c:when test="${person.new}">
            <c:set var="method" value="post" />
            New
        </c:when>
        <c:otherwise>
            <c:set var="method" value="put" />
            Edit
        </c:otherwise>
    </c:choose>
    Person
    </div>
    <div class="innercontentmiddlebody">
    <form:form modelAttribute="person" method="${method}">

        <p class="container">
        <form:label class="form-label" path="firstName"  cssErrorClass="form-label errors">First Name</form:label>
        <form:input class="input-text" path="firstName" />
        <form:errors path="firstName" cssClass="errors" />
        </p>

        <p class="container">
        <form:label class="form-label" path="surname"  cssErrorClass="form-label errors">Surname</form:label>
        <form:select class="input-select" path="surname">
            <form:option value="" label="--Please Select"/>
            <form:options items="${surnames}" itemValue="id" itemLabel="name" />
        </form:select>
        <form:errors path="surname" cssClass="errors" />
        </p>

        <p class="container">
            <form:label class="form-label" path="gender"  cssErrorClass="form-label errors">Gender</form:label>
            <form:radiobuttons class="input-radiobuttons" path="gender" items="${genderOptions}" />
            <form:errors path="gender" cssClass="errors" />
        </p>

        <p class="container">
        <form:label class="form-label" path="father"  cssErrorClass="form-label errors">Father</form:label>
        <form:select class="input-select" path="father">
            <form:option value="" label="--Please Select"/>
            <form:options items="${fathers}" itemValue="id" itemLabel="fullname" />
        </form:select>
        <form:errors path="father" cssClass="errors" />
        </p>

        <p class="container">
        <form:label class="form-label" path="mother"  cssErrorClass="form-label errors">Mother</form:label>
        <form:select class="input-select" path="mother">
            <form:option value="" label="--Please Select"/>
            <form:options items="${mothers}" itemValue="id" itemLabel="fullname" />
        </form:select>
        <form:errors path="mother" cssClass="errors" />
        </p>

        <p class="container">
            <form:label class="form-label" path="birthDate"  cssErrorClass="form-label errors">Date of Birth</form:label>
            <form:input class="input-text" path="birthDate" />
            <form:errors path="mother" cssClass="errors" />
        </p>

        <p class="container">
        <c:choose>
            <c:when test="${person.new}">
                <input id="submit" type="submit" value="Add Person" />
            </c:when>
            <c:otherwise>
                <input id="submit" type="submit" value="Update Person" />
            </c:otherwise>
        </c:choose>
        </p>
    </form:form>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>