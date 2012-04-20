<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="generation" id="firstGeneration">
<c:forEach var="person" items="${immediateFamily.parents}" varStatus="personLoopCount" >
    <c:if test="${personLoopCount.count > 1}">
        <div class="marriagejoin"></div>
    </c:if>
    <div class="treenode" id="${person.id}"><div class="fullname">${person.fullname}</div></div>
</c:forEach>
</div>
<div class="generation" id="secondGeneration">
<c:forEach var="person" items="${immediateFamily.siblings}" varStatus="personLoopCount" >
    <c:if test="${personLoopCount.count > 1}">
        <div class="nodespace"></div>
    </c:if>
    <div class="treenode" id="${person.id}"><div class="fullname">${person.fullname}</div></div>
</c:forEach>
</div>
<div class="generation" id="thirdGeneration">
<c:forEach var="person" items="${immediateFamily.children}"  varStatus="personLoopCount" >
    <c:if test="${personLoopCount.count > 1}">
        <div class="nodespace"></div>
    </c:if>
    <div class="treenode" id="${person.id}"><div class="fullname">${person.fullname}</div></div>
</c:forEach>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>