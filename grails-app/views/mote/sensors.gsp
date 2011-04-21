<%@ page import="com.portcullis.SensorType" %>
<meta name="layout" content="main"/>
<div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li>Sensors</li>
    </ul>
</div>
<div class="pageTitle">Sensors</div>
<div class="subTitle">${mote.name}</div>
<div class="mainContent">

    <div id="newMote"><g:link controller="mote" action="newSensor" id="${mote.id}">Add Sensor</g:link></div>
        <g:each in="${sensors}" var="sensor">
            <p class="sensorList">
                    <g:if test="${sensor.sensortype == SensorType.PH}"><img src="<g:resource dir="images/sensorTypes" file="ph.png"/>"/></g:if>
                    <g:if test="${sensor.sensortype == SensorType.Light}"><img src="<g:resource dir="images/sensorTypes" file="light.png"/>"/></g:if>
                    <g:if test="${sensor.sensortype == SensorType.Temperature}"><img src="<g:resource dir="images/sensorTypes" file="temp.png"/>"/></g:if>
                    <g:if test="${sensor.sensortype == SensorType.Voltage}"><img src="<g:resource dir="images/sensorTypes" file="voltage.png"/>"/></g:if>
                </span>
                <span class="sensorInfo">${sensor.sid} - ${sensor.name} ${sensor.sensortype}</span>
                <g:link action="editSensor" controller="mote" params="[id:sensor.id, moteId:mote.id]"><img src="<g:resource file="gear.png" dir="images"/>" title="Edit Sensor"  alt="Config"/></g:link> <g:link action="deleteSensor" controller="mote"  params="[id:sensor.id, moteId:mote.id]"><img src="<g:resource file="Delete.png" dir="images"/>" title="Delete"  alt="Delete"/></g:link>
            </p>
    </g:each>
    </table>
</div>