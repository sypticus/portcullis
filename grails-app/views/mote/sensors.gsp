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
         <td>${sensor.sid}</td><td>${sensor.sensortype}</td>
     </tr>
</g:each>
</table>