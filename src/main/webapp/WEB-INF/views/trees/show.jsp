<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:85%">Details for tree with common ancestory ${tree.person.fullname}</div>
        <div style="float:left;width:15%"><a style="font-size:0.8em;" href="<c:url value="/trees/${tree.id}/edit" />">Edit Tree</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <div id="description">${tree.description}</div>
        <div id="commonAncestor">${tree.person.fullname}</div>
        <div><a href="/trees/${tree.person.id}/view">View tree</a></div>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>



