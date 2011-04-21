$(function(){
    $("#createForm").validate({
        rules: {
            username: {
                required:true,
                email:true
            },
             password: {
                required:true
            },
            confirmPassword:{
                required:true,
                 equalTo: "#password"
            }
        },
        messages:{
            username:  "Please enter a valid email.",
            password:  "Please enter a valid password.",
            confirmPassword:"Passwords must match"

        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
    }
    });
});