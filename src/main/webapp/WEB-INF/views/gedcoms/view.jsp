<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="gedcomContents" uri="gedcomContents" %>

<gedcomContents:gedcom gedcomDetails="${gedcomDetails}">
    ${gedcomIndividual.firstName}
    ${gedcomIndividual.surname}
    ${gedcomIndividual.birthDate}
    ${gedcomIndividual.birthPlace}
</gedcomContents:gedcom>

<%@ include file="/WEB-INF/views/footer.jsp" %>