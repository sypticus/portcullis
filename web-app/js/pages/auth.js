$(function(){
    $("#loginForm").validate({
        rules: {
            j_username: {
                required:true,
                email:true
            },
             j_password: {
                required:true
            }
        },
        messages:{
            j_username:  "Please enter a valid email.",
            j_password:  "Please enter a valid password."

        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
    }
    });
});