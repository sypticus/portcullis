<head>
    <meta name="layout" content="main"/>
    <g:javascript library="pages/newMote" />
    <title>New Mote</title>
</head>
<div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li>New Mote</li>
    </ul>
</div>
  <div class="pageTitle">New Mote</div>
  <div class="mainContent">
    <div id="newMoteDiv">
        <g:form action="addMote" name="addMote" controller="mote">
        <p class="newMoteInputP">
            <label for="id">Id:</label>
            <g:textField name="id"/>
        </p>
        <p class="newMoteInputP">
            <label for="name">Name:</label>
            <g:textField name="name"/>
        </p>
            <g:submitButton class="submit" name="Submit" value="Submit"/>

    </g:form>
    </div>
</div>
