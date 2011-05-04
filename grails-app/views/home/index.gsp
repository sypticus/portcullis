<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="layout" content="main"/>
</head>
<g:javascript library="flot/jquery.flot" />
<g:javascript library="pages/home" />
<div class="breadCrumbs"></div>
<div class="pageTitle">Home</div>

<div class="mainContent">
    <g:if test="${!sensors}">
        You have no Key Sensors configured yet.
    </g:if>
    <g:else>
        <g:each in="${sensors}" var="sensor">
            <div class="sensorNameDiv">${sensor.id} - ${sensor.name}</div>
            <g:hiddenField class="sensorHidden" name="sensor${sensor.id}" value="${sensor.id}"/>
            <div class="graph" id="placeholder_${sensor.id}" style="width:600px;height:300px;"></div>
            <div class="graphOptions">
                <g:link action="removeFromHome" id="${sensor.id}" controller="home">
                    Remove from Home
                </g:link>
                Max Results:
				<g:select name="maxlength_${sensor.id}" value="50" from="[50]"/>
            </div>
        </g:each>
    </g:else>
</div>
