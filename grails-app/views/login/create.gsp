<head>
    <meta name='layout' content='security' />
    <g:javascript library="pages/create" />
    <title>Login</title>
</head>

<body>
	<div id='login'>
		<div class='inner'>
			<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
			</g:if>

			<div id="loginDiv">
                <div class='fheader'>Create Account</div>
                <g:form controller="login" id="createForm" name="createForm" action='processCreate' method='POST' class='cssform' autocomplete='off'>
                    <p class="loginP">
                        <label for='username'>Email</label>
                        <input type='text' class='text_' name="username" id='username' />
                    </p>
                    <p class="loginP">
                        <label for='password'>Password</label>
                        <input type='password' class='text_' name='password' id='password' />
                    </p>
                    <p class="loginP">
                        <label for='confirmPassword'>Confirm Password</label>
                        <input type='password' class='text_' name='confirmPassword' id='confirmPassword' />
                    </p>
                    <p>
                        <input type='submit' value='Create' />  <g:link action="auth" controller="login">cancel</g:link>
                    </p>
                </g:form>
            </div>
		</div>
	</div>
</body>
