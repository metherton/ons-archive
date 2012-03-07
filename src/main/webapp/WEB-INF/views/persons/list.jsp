<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="personDetails" uri="personDetails" %>

<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">Births</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/persons/new" />">Add New Birth</a></div>
        <div style="clear:both;"></div>
    </div>
    <br />
    <div class="innercontentmiddlebody">
        <personDetails:person persons="${persons}">
            <div style="width: 100%">
            <div style="float:left;width:40%;font-size:small;;padding:0.5em;" id="personFullName"><a href="<c:url value="/persons/${person.id}" />">${person.fullname}&nbsp;</a></div>
            <div style="float:left;width:40%;font-size:small;;padding:0.5em;" id="personBirthDate"><a href="<c:url value="/persons/${person.id}" />"><fmt:formatDate value="${person.birthDate}" />&nbsp;</a></div>
            <div style="clear:both;"></div>
            </div>
        </personDetails:person>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


