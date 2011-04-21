<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main"/>
    <title>Configure Motes</title>
</head>
<g:javascript library="pages/home" />
<div class="breadCrumbs"></div>
<div class="pageTitle">Motes</div>
<div class="mainContent">
    <div id="newMote"><g:link action="newMote" controller="mote">Add Mote</g:link></div>
    <g:each in="${motes}" var="mote">
        <p class="moteList">
            <g:link controller="mote" action="results" id="${mote.id}" class="hardLink"><span class="moteInfo">${mote.mid} - ${mote.name}</SPAN></g:link>
            <g:link controller="mote" action="results" id="${mote.id}"><img src="<g:resource file="graph.png" dir="images"/>" title="Sensor Results"  alt="Sensor Results"/></g:link>

            <g:link controller="mote" action="config" id="${mote.id}"><img src="<g:resource file="gear.png" dir="images"/>" title="Edit Mote"  alt="Config"/></g:link>
            <g:link action="sensors" controller="mote" id="${mote.id}"><img src="<g:resource file="plugins.png" dir="images"/>" title="Sensors"  alt="Sensors"/></g:link>
            <g:link action="deleteMote" id="${mote.id}" controller="mote"><img src="<g:resource file="Delete.png" dir="images"/>" title="Delete"  alt="Delete"/></g:link>

        </p>
    </g:each>
</div>
