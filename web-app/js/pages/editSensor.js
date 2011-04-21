$(function(){
    $("#updateSensor").validate({
        rules: {
            sid: {
                required:true
            },
            name: {
                required:true
            },
            sensorType:{
                required:true
            }
        },
        messages:{
            sid:  "Please enter a valid id.",
            name:  "Please enter a valid name.",
            sensorType:"Please select a type"

        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
    }
    });
});