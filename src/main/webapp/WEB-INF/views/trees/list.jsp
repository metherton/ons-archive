<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">List of Etherton trees in our database</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/trees/new" />">Add New Tree</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <c:forEach var="tree" items="${trees}">
            <div id="tree"><a href="<c:url value="/trees/${tree.id}" />">${tree.description}</a></div>
        </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


