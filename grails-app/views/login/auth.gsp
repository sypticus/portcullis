<head>
    <meta name='layout' content='security' />
    <g:javascript library="pages/auth" />
    <title>Login</title>

</head>

<body>
	<div id='login'>
		<div class='inner'>


			<div id="loginDiv">
                 <div class='fheader'>Login</div>
                <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                    <p class="loginP">
                        <label for='username'>Email</label>
                        <input type='text' class='text_ required' name='j_username' id='username' />
                    </p>

                    <p class="loginP">
                        <label for='password'>Password</label>
                        <input type='password' class='text_' name='j_password' id='password' />
                    </p>

                      <p class="loginP">
                        <label for='remember_me' style="width:150px;">Remember me</label>
                        <input type='checkbox' class='chk' style="width:20px;" name='${rememberMeParameter}' id='remember_me'
                        <g:if test='${hasCookie}'>checked='checked'</g:if> />
                    </p>
                    <p style="text-align:center">
                        <input type='submit' value='Login' /> <g:link action="create" controller="login">New Account</g:link>
                    </p>

                </form>
            </div>
		</div>
	</div>

</body>
<script type='text/javascript'>

(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
</script>