<%@ page import="com.portcullis.SensorType" %>
<head>
    <meta name="layout" content="main"/>

    <title>Edit Sensor</title>
</head>
<g:javascript library="pages/editSensor" />
<div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li><g:link action="sensors" id="${mote.id}" controller="mote" >Sensors</g:link></li>
        <li>Edit Sensor</li>
    </ul>
</div>
 <div class="pageTitle">Edit Sensor</div>
<div class="subTitle">${mote.name} - ${sensor.name}</div>
<div class="mainContent">
    <div id="newSensorDiv">
        <g:form action="updateSensor" name="updateSensor" controller="mote" id="${sensor.id}">
        <p class="newSensorInputP">
            <label for="sid">Id:</label>
            <g:textField name="sid"  value="${sensor.sid}"/>
        </p>
        <p class="newSensorInputP">
            <label for="name">Name:</label>
            <g:textField name="name"  value="${sensor.name}"/>
        </p>
         <p class="newSensorInputP">
            <label for="sensorType">Type:</label>
            <g:select  noSelection="${['':'Select One...']}" value="${sensor.sensortype}" name="sensorType" from="${SensorType}"/>
        </p>
           <g:hiddenField name="moteId" value="${mote.id}"/>
            <g:submitButton class="submit" name="Submit" value="Submit"/>

    </g:form>
    </div>
</div>
