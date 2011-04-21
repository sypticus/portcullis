<head>
    <meta name="layout" content="main"/>
    <g:javascript library="pages/configMote" />
    <title>Config Mote</title>
</head>
<div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li>Edit Mote</li>
    </ul>
</div>
  <div class="pageTitle">Edit Mote</div>
  <div class="subTitle">${mote.name}</div>
  <div class="mainContent">
    <div id="newMoteDiv">
        <g:form action="updateMote" name="updateMote" id="${mote.id}" controller="mote">
            <p class="newMoteInputP">
                <label for="mid">Id:</label>
                <g:textField name="mid" value="${mote.mid}"/>
            </p>
            <p class="newMoteInputP">
                <label for="name">Name:</label>
                <g:textField name="name" value="${mote.name}"/>
            </p>
            <p class="newMoteInputP">
                <g:submitButton class="submit" name="Submit" value="Submit"/>
            </p>
        </g:form>
    </div>
</div>



