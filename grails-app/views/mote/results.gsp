<head>
    <meta name="layout" content="main"/>
      <g:javascript library="flot/jquery.flot" />

    <title>Sensor Data</title>
</head>
<g:javascript library="pages/results" />
 <div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li>Sensor Data</li>
    </ul>
</div>
 <div class="pageTitle">Sensor Data</div>
<div class="subTitle">${mote.name}</div>
<div class="mainContent">
    <g:if test="${!mote.sensors}">
        You have not added any <g:link action="sensors" controller="mote" id="${mote.id}">sensors</g:link> to this mote.
    </g:if>
<g:each var="sensor" in="${mote.sensors?.sort{it.sid}}">
    <div class="sensorNameDiv">${sensor.id} - ${sensor.name}</div>   
    <g:hiddenField class="sensorHidden" name="sensor${sensor.id}" value="${sensor.id}"/>
    <div class="graph" id="placeholder_${sensor.id}" style="width:600px;height:300px;"></div>
    <div class="graphOptions">
        <g:link action="addToHome" id="${sensor.id}" controller="home">
            Add to Home
        </g:link>
	    Max Results:
	<g:select name="maxlength_${sensor.id}" value="50" from="[50]"/>
    </div>
</g:each>
</div>

