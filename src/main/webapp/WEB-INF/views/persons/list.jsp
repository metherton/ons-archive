<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<c:forEach var="person" items="${persons}">
    <div id="person">${person.fullname}</div>
</c:forEach>

