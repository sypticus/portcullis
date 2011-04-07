  <meta name="layout" content="main"/></head>
<g:form action="updateMote" id="${mote.id}" controller="mote">
    Name:
    <g:textField name="name" value="${mote.name}"/>
    Id:
    <g:textField name="mid" value="${mote.mid}"/>
    <g:submitButton name="Submit" value="Submit"/>
</g:form>