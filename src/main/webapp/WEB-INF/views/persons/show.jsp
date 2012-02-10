<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:85%">Details for ${person.fullname}</div>
        <div style="float:left;width:15%"><a style="font-size:0.8em;" href="<c:url value="/persons/${person.id}/edit" />">Edit Person</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
<div id="firstName">${person.firstName}</div>
<div id="surname">${person.surname.name}</div>
<div id="father">${person.father.firstName} ${person.father.surname.name}</div>
<div id="mother">${person.mother.firstName} ${person.mother.surname.name}</div>
<div id="gender"><c:if test="${person.gender}">Male</c:if><c:if test="not ${person.gender}">Female</c:if></div>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>

