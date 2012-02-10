<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        <div style="float:left;width:85%">Details for ${surname.name} surname</div>
        <div style="float:left;width:15%"><a style="font-size:0.8em;" href="<c:url value="/surnames/${surname.id}/edit" />">Edit Surname</a></div>
        <div style="clear:both;"></div>
    </div>
    <div class="innercontentmiddlebody">
        <div id="name">${surname.name}</div>
    </div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>

