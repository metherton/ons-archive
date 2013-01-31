<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="familyTreeNodeDetails" uri="familyTreeNodeDetails" %>

<div class="tree-container" style="width:100%; overflow: scroll; height: 40em; background-color: honeydew; border: 0.2em solid lightgrey;" >
    <familyTreeNodeDetails:familyTreeNode immediateFamily="${immediateFamily}">
        <c:if test="${familyTreeNode.id > 0}"><a class="treenode-link" href="<c:url value="/trees/${familyTreeNode.id}/view" />"></c:if>
        <div class="treenode" style="position: absolute;padding-top:${familyTreeNode.paddingTop}em;padding-bottom:${familyTreeNode.paddingBottom}em;padding-left:${familyTreeNode.paddingLeft}em;padding-right:${familyTreeNode.paddingRight}em;height:${familyTreeNode.height}em;width: ${familyTreeNode.width}em; top: ${familyTreeNode.top}em ; left: ${familyTreeNode.left}em" id="${familyTreeNode.id}">
            <div style="background-color: #F5FAFF; height: ${familyTreeNode.height}em; width: ${familyTreeNode.width}em " id="${familyTreeNode.id}" class="fullname"><div>${familyTreeNode.fullname}</div><div>b:&nbsp;${familyTreeNode.birthDate}</div><div>${familyTreeNode.location}</div></div>
            <div class="mline" style="display: ${familyTreeNode.mlineDisplay};top:${familyTreeNode.mlineTop}em; left: ${familyTreeNode.mlineLeft}em; width: ${familyTreeNode.mlineWidth}em "></div>
            <div class="pline">
                <div style="display:${familyTreeNode.l1PlineDisplay};left: ${familyTreeNode.l1PlineLeft}%; top: -${familyTreeNode.l1PlineTop}em" class="l1"></div>
                <div style="display:${familyTreeNode.l2PlineDisplay}; width: ${familyTreeNode.l2PlineWidth}%; left: ${familyTreeNode.l2PlineLeft}%" class="l2"></div>
                <div style="display:${familyTreeNode.l3PlineDisplay}; height: ${familyTreeNode.paddingTop}em" class="l3"></div>
            </div>
        </div>
        <c:if test="${familyTreeNode.id > 0}"></a></c:if>
    </familyTreeNodeDetails:familyTreeNode>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>