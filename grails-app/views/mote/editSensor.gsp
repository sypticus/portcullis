<%@ page import="com.portcullis.SensorType" %>
  <meta name="layout" content="main"/>
<g:form action="updateSensor" controller="mote" id="${sensor.id}">
    Id:
    <g:textField name="sid" value="${sensor.sid}"/>
    Type:
    <g:select name="sensorType" from="${SensorType}" value="${sensor.sensortype}"/>
     <g:hiddenField name="moteId" value="${mote.id}"/>
    <g:submitButton name="Submit" value="Submit"/>
</g:form>