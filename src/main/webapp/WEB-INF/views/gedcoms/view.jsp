<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="gedcomContents" uri="gedcomContents" %>

<form method="GET" name="myform">

<select name="individual">
<gedcomContents:gedcom gedcomDetails="${gedcomDetails}">
    <option id=${gedcom.id}>${gedcomIndividual.firstName}&nbsp;${gedcomIndividual.surname}&nbsp;${gedcomIndividual.birthDate}&nbsp;,&nbsp;${gedcomIndividual.birthPlace}</option>
</gedcomContents:gedcom>
</select>
<br />
<select name="tree"  onchange="document.myform.submit()">
    <option value="">Please select a tree to merge into</option>
    <gedcomContents:gedcomtree trees="${trees}" selectedTree="${selectedTree}">
        <option <c:if test="${selectedTree eq tree.id}">selected</c:if> id=${tree.id} value="${tree.id}">${tree.description}</option>
    </gedcomContents:gedcomtree>
</select>
<br />
<input type="radio" name="relation" value="parent">Parent&nbsp;<input type="radio" name="relation" value="child">Child&nbsp;<input type="radio" name="relation" value="sibling">Sibling
<br />
<select name="person">
    <option value="">Please select a person to merge with</option>
    <gedcomContents:person persons="${persons}">
        <option id=${person.id} value="${person.id}">${person.fullname}</option>
    </gedcomContents:person>
</select>

</form>    
<%@ include file="/WEB-INF/views/footer.jsp" %>