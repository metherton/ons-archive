<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<c:forEach var="tree" items="${trees}">
    <div id="tree">${tree.description}</div>
</c:forEach>

