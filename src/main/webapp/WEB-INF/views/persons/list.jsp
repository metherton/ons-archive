<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">List of People in our database</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/persons/new" />">Add New Person</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <c:forEach var="person" items="${persons}">
            <div id="person"><a href="<c:url value="/persons/${person.id}" />">${person.fullname}</a></div>
        </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


