  <meta name="layout" content="main"/>
Mote: ${mote.name}
<g:link controller="mote" action="newSensor" id="${mote.id}">add</g:link>
<table>
<tr>
    <td>
        <b>Id</b>
    </td>
    <td>
        <b>Type</b>
    </td>
</tr>
    <g:each in="${sensors}" var="sensor">
     <tr>
         <td>${sensor.sid}</td><td>${sensor.sensortype}</td>  <td><g:link action="editSensor" controller="mote" params="[id:sensor.id, moteId:mote.id]">edit</g:link> | <g:link action="deleteSensor" controller="mote"  params="[id:sensor.id, moteId:mote.id]">delete</g:link> </td>
     </tr>
</g:each>
</table>