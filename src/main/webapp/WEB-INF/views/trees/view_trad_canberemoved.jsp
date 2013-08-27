<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="tree-container" >
    <div id="firstGeneration">
    <c:forEach var="person" items="${immediateFamily.parents}" varStatus="personLoopCount" >
        <c:if test="${personLoopCount.count > 1}">
            <div class="mline" style="top:3.8em; left: 12em; width: 4em;"></div>
        </c:if>
        <div class="treenode" style="top: 0; left: ${(personLoopCount.count - 1) * 14}em" id="${person.id}">
            <div class="fullname">${person.fullname}</div>
            <div class="pline">
                <div style="display:none" class="l1"></div>
                <div style="display:none" class="l2"></div>
                <div style="display:none" class="l3"></div>
            </div>
        </div>
    </c:forEach>
    </div>
    <div id="secondGeneration">
    <c:forEach var="person" items="${immediateFamily.siblings}" varStatus="personLoopCount" >
        <c:if test="${person.id == activePersonId && fn:length(immediateFamily.wives) > 0}">
            <div class="treenode" style="top: 8em; left: ${(personLoopCount.count - 1) * 14}em" id="${person.id}">
                <div class="fullname">${person.fullname}</div>
                <div class="pline">
                    <div class="l1" style="left:<c:if test="${personLoopCount.count == 1}">100%</c:if><c:if test="${personLoopCount.count > 1}">-${(personLoopCount.count - 1)*100}%</c:if>;<c:if test="${personLoopCount.count > 1}">display:none</c:if>"></div>
                    <div class="l2" style="left:<c:if test="${personLoopCount.count == 1}">50%</c:if><c:if test="${personLoopCount.count == 2}">0</c:if><c:if test="${personLoopCount.count > 2}">-${(personLoopCount.count - 2)*100}%</c:if>;width:<c:if test="${personLoopCount.count < 3}">50%</c:if><c:if test="${personLoopCount.count > 2}">${((personLoopCount.count - 2)*100)+50}%</c:if>"></div>
                    <div class="l3"></div>
                </div>
            </div>
        </c:if>
        <div class="treenode" style="top: 8em; left: ${(personLoopCount.count - 1) * 14}em" id="${person.id}">
            <div class="fullname">${person.fullname}</div>
            <div class="pline">
                <div class="l1" style="left:<c:if test="${personLoopCount.count == 1}">100%</c:if><c:if test="${personLoopCount.count > 1}">-${(personLoopCount.count - 1)*100}%</c:if>;<c:if test="${personLoopCount.count > 1}">display:none</c:if>"></div>
                <div class="l2" style="left:<c:if test="${personLoopCount.count == 1}">50%</c:if><c:if test="${personLoopCount.count == 2}">0</c:if><c:if test="${personLoopCount.count > 2}">-${(personLoopCount.count - 2)*100}%</c:if>;width:<c:if test="${personLoopCount.count < 3}">50%</c:if><c:if test="${personLoopCount.count > 2}">${((personLoopCount.count - 2)*100)+50}%</c:if>"></div>
                <div class="l3"></div>
            </div>
        </div>
    </c:forEach>
    </div>
    <div id="thirdGeneration">
    <c:forEach var="person" items="${immediateFamily.children}"  varStatus="personLoopCount" >
        <c:if test="${personLoopCount.count > 1}">
        </c:if>
        <div class="treenode" style="top: 16em; left: ${(personLoopCount.count - 1 + childPositioningOffset) * 14}em" id="${person.id}">
            <div class="fullname">${person.fullname}</div>
            <div class="pline">
                <div class="l1" style="left:<c:if test="${personLoopCount.count == 1}">100%</c:if><c:if test="${personLoopCount.count > 1}">-${(personLoopCount.count - 1)*100}%</c:if>;<c:if test="${personLoopCount.count > 1}">display:none</c:if>"></div>
                <div class="l2" style="left:<c:if test="${personLoopCount.count == 1}">50%</c:if><c:if test="${personLoopCount.count == 2}">0</c:if><c:if test="${personLoopCount.count > 2}">-${(personLoopCount.count - 2)*100}%</c:if>;width:<c:if test="${personLoopCount.count < 3}">50%</c:if><c:if test="${personLoopCount.count > 2}">${((personLoopCount.count - 2)*100)+50}%</c:if>"></div>
                <div class="l3"></div>
            </div>
        </div>
    </c:forEach>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>