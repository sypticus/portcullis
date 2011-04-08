<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>

        <div id="headerBar">
            <div id="logo" style="display: inline-block; vertical-align:middle;"><g:link action="index" controller="home"><img src="${resource(dir:'images',file:'Portcullis.jpg')}" height="60" alt="Grails" border="0" /> <h2 style="display: inline-block;">Portcullis</h2></g:link></div>
            <div style="float:right; margin:20px; font-size:15px;">
                <g:link action="index" controller="home">Home</g:link>|
                <g:link action="index" controller="mote">Motes</g:link>|
                <g:link action="index" controller="logout">Logout</g:link>

            </div>
        </div>
    <div class="mainBody">
        <g:layoutBody />
    </div>
    </body>
</html>