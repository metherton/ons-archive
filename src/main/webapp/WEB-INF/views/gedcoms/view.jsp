<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="gedcomContents" uri="gedcomContents" %>

<select name="person">
<gedcomContents:gedcom gedcomDetails="${gedcomDetails}">
    <option id=${gedcom.id}>${gedcomIndividual.firstName}&nbsp;${gedcomIndividual.surname}&nbsp;${gedcomIndividual.birthDate}&nbsp;,&nbsp;${gedcomIndividual.birthPlace}</option>
</gedcomContents:gedcom>
</select>
<br />
<input type="radio" name="relation" value="parent">Parent&nbsp;<input type="radio" name="relation" value="child">Child&nbsp;<input type="radio" name="relation" value="sibling">Sibling
<br />
<select name="tree">

</select>
<%@ include file="/WEB-INF/views/footer.jsp" %>