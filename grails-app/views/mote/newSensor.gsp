<%@ page import="com.portcullis.SensorType" %>
<head>
    <meta name="layout" content="main"/>
    <g:javascript library="pages/newSensor" />
    <title>New Sensor</title>

</head>

<div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li><g:link action="sensors" id="${mote.id}" controller="mote" >Sensors</g:link></li>
        <li>Add Sensor</li>
    </ul>
</div>
<div class="pageTitle">Add Sensor</div>
<div class="subTitle">${mote.name}</div>
<div class="mainContent">
    <div id="newSensorDiv">
        <g:form action="addSensor" name="addSensor" controller="mote" id="${mote.id}">
        <p class="newSensorInputP">
            <label for="sid">Id:</label>
            <g:textField name="sid"/>
        </p>
        <p class="newSensorInputP">
            <label for="name">Name:</label>
            <g:textField name="name"/>
        </p>
         <p class="newSensorInputP">
            <label for="sensorType">Type:</label>
            <g:select  noSelection="${['':'Select One...']}"  name="sensorType" from="${SensorType}"/>
        </p>

            <g:submitButton class="submit" name="Submit" value="Submit"/>

    </g:form>
    </div>
</div>