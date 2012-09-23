<%@ include file="/WEB-INF/views/includes.jsp" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<%@ taglib prefix="gedcomContents" uri="gedcomContents" %>

<form method="GET" >

<select name="individual">
<gedcomContents:gedcom gedcomDetails="${gedcomDetails}">
    <option id=${gedcom.id}>${gedcomIndividual.firstName}&nbsp;${gedcomIndividual.surname}&nbsp;${gedcomIndividual.birthDate}&nbsp;,&nbsp;${gedcomIndividual.birthPlace}</option>
</gedcomContents:gedcom>
</select>
<br />
<select name="tree">
    <option>Please select a tree to merge into</option>
    <gedcomContents:gedcomtree trees="${trees}">
        <option id=${tree.id}>${tree.description}</option>
    </gedcomContents:gedcomtree>
</select>
<br />
<input type="radio" name="relation" value="parent">Parent&nbsp;<input type="radio" name="relation" value="child">Child&nbsp;<input type="radio" name="relation" value="sibling">Sibling
<br />
<select name="person">
    <option>Please select a tree to merge into</option>
    <gedcomContents:person persons="${persons}">
        <option id=${person.id}>${person.fullname}</option>
    </gedcomContents:person>
</select>

</form>    
<%@ include file="/WEB-INF/views/footer.jsp" %>