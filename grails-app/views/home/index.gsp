<g:link action="index" controller="mote">View Motes</g:link>
<g:each in="${motes}" var="mote">
${mote.name}
    <g:each in="${mote.sensors}" var="sensor">
        ${sensor.name}
    </g:each>
</g:each>