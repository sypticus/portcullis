<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="${resource(dir:'css',file:'security.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />

        <g:javascript library="jquery-1.5.2.min" />
        <g:javascript library="jQueryPlugins/jquery.validate.min" />
        <g:javascript library="jQueryPlugins/additional-methods" />
         <g:layoutHead />
    </head>
    <body>

    <div class="mainBody">
        <g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
			</g:if>
        <g:layoutBody />
    </div>
    </body>
</html>