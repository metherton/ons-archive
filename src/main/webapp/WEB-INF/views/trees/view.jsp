<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div id="firstGeneration">
<c:forEach var="person" items="${relatives.parents}" >
    <div id="${person.id}">${person.fullname}</div>
</c:forEach>
</div>
<div id="secondGeneration">
<c:forEach var="person" items="${relatives.siblings}" >
    <div id="${person.id}">${person.fullname}</div>
</c:forEach>
</div>
<div id="thirdGeneration">
<c:forEach var="person" items="${relatives.children}" >
    <div id="${person.id}">${person.fullname}</div>
</c:forEach>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>