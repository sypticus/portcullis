<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:javascript library="jquery-1.5.2.min" />
        <g:javascript library="jQueryPlugins/jquery.validate.min" />
        <g:javascript library="jQueryPlugins/additional-methods" />
        <g:layoutHead />
    </head>
    <body>

        <div id="headerBar">
          <div>Image goes here!!!</div>

        </div>
    <div id="navTop"></div>
    <div id="navigation">
        <ul id='ulNav'>
            <li>
                <g:link action="index" controller="home">Home</g:link>
            </li>

            <li>
                 <g:link action="index" controller="mote">Motes</g:link>
            </li>
            <li>
                <g:link action="index" controller="logout">Logout</g:link>

            </li>
        </ul>

                    </div>
    <div class="mainBody">
        <g:layoutBody />
    </div>
    </body>
</html>