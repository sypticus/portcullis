  <meta name="layout" content="main"/>
<%@ page import="com.portcullis.SensorType" %>
<g:form action="addSensor" controller="mote" id="${mote.id}">
    Id:
    <g:textField name="sid"/>
    Type:
    <g:select name="sensorType" from="${SensorType}"/>

    <g:submitButton name="Submit" value="Submit"/>
</g:form>