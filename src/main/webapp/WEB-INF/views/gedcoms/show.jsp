<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<div class="innercontentmiddle">
    <div class="innercontentmiddleheader">
        Details for ${gedcom.title}
    </div>
    <div class="innercontentmiddlebody">
        <div id="title">${gedcom.title}</div>
    </div>
    <div><a href="<c:url value="/gedcoms/${gedcom.id}/view?tree=0" />">View Gedcom Contents</a></div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>

