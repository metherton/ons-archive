<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">Births</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/persons/new" />">Add New Birth</a></div>
        <div style="clear:both;"></div>
    </div>
    <br />
    <div class="innercontentmiddlebody">
        <c:forEach var="person" items="${persons}" varStatus="loopStatus">
            <div style="width: 100%">
            <div style="float:left;width:40%;font-size:small;border-top-style:dashed;border-right-style:dashed;border-left-style:dashed;border-width:thin;;padding:0.5em;background-color: ${loopStatus.index % 2 == 0 ? '#FFFFFF' : '#F5FFFA '}" id="person"><a href="<c:url value="/persons/${person.id}" />">${person.fullname}&nbsp;</a></div>
            <div style="float:left;width:40%;font-size:small;border-top-style:dashed;border-right-style:dashed;;border-width:thin;;padding:0.5em;background-color: ${loopStatus.index % 2 == 0 ? '#FFFFFF' : '#F5FFFA '}" id="person"><a href="<c:url value="/persons/${person.id}" />"><fmt:formatDate value="${person.birthDate}" />&nbsp;</a></div>
            <div style="clear:both;"></div>
            </div>
        </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


