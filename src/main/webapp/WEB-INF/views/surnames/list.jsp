<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<c:forEach var="surname" items="${surnames}">
    <div id="surname">${surname.name}</div>
</c:forEach>

