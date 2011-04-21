$(function(){
    $("#addMote").validate({
        rules: {
            id: {
                required:true
            },
            name: {
                required:true
            }

        },
        messages:{
            id:  "Please enter a valid id.",
            name:  "Please enter a valid name."

        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
    }
    });
});