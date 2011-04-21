$(function () {
    dataurl = "home/getStates";
      poll();
      window.setInterval(poll, 10000);
    var options = {
        lines: { show: true },
        points: { show: true },
        xaxis: {
          mode: "time",
          minTickSize: [1, "second"]
      }
    };

    function poll(){
        $(".sensorHidden").each(function(index){

            updateSensorData(this.value);
        });


    }

     function updateSensorData(sensorId){
        $.ajax({
            url: dataurl,
             data: ({sensorId : sensorId, timeStamp:0}),
            method: 'GET',
            dataType: 'json',
            success: function(data){
                onDataReceived(data, sensorId)
            }
        });
     }

     function onDataReceived(data, sensorId){
        series = data.series;
        type = data.type;
        var obj = [{label: type, data: series}]
        plotData(obj, sensorId)


    };

    function plotData(data, sensorId){
         var placeholder = $("#placeholder_"+sensorId);
        $.plot(placeholder, data, options);
    }
 });