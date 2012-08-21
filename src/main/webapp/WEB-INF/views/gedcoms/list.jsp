<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">List of Gedcoms in our database</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/gedcoms/new" />">Add New Gedcom</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <c:forEach var="gedcom" items="${gedcoms}">
            <div id="gedcom"><a href="<c:url value="/gedcoms/${gedcom.id}" />">${gedcom.title}</a></div>
        </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


