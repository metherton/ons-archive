<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div id="fullName" style="float:left;width:85%">Details for ${person.fullname}</div>
        <div style="float:left;width:15%"><a style="font-size:0.8em;" href="<c:url value="/persons/${person.id}/edit" />">Edit Birth</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <div id="father"><div style="float:left;width:10em">Father:</div><div style="float:left;width:10em">${person.father.firstName} ${person.father.surname.name}</div><div style="clear:both;"></div></div>
        <div id="mother"><div style="float:left;width:10em">Mother:</div><div style="float:left;width:10em">${person.mother.firstName} ${person.mother.surname.name}</div><div style="clear:both;"></div></div>
        <div id="gender"><div style="float:left;width:10em">Gender:</div><div style="float:left;width:10em"><c:choose><c:when test="${person.gender}">Male</c:when><c:otherwise>Female</c:otherwise></c:choose></div><div style="clear:both;"></div></div>
        <div id="birthDate"><div style="float:left;width:10em">Date of Birth:</div><div style="float:left;width:10em"><fmt:formatDate value="${person.birthDate}" /></div><div style="clear:both;"></div></div>
        <div id="map_canvas" style="width:300px; height:300px"></div>
        <input type="hidden" id="latitude" value="${person.latitude}" />
        <input type="hidden" id="longitude" value="${person.longitude}" />
    </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>

