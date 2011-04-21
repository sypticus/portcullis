$(function(){
    $("#updateMote").validate({
        rules: {
            mid: {
                required:true
            },
            name: {
                required:true
            }

        },
        messages:{
            mid:  "Please enter a valid id.",
            name:  "Please enter a valid name."

        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
    }
    });
});