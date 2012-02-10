<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:80%">List of Surnames in our database</div>
        <div style="float:left;width:20%"><a style="font-size:0.8em;" href="<c:url value="/surnames/new" />">Add New Surname</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <c:forEach var="surname" items="${surnames}">
            <div id="surname"><a href="<c:url value="/surnames/${surname.id}" />">${surname.name}</a></div>
        </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>


