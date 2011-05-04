$(function () {
      var sensorData=new Array();
      dataurl = "home/getStates";
      poll();
      window.setInterval(poll, 10000);
    var options = {
        lines: { show: true },
        points: { show: true },
        xaxis: {
          mode: "time",
          minTickSize: [20, "second"]
      }
    };

    function poll(){
        $(".sensorHidden").each(function(index){

            updateSensorData(this.value);
        });


    }

     function updateSensorData(sensorId){
         timestamp = 0;
         if(sensorData[sensorId])
            timestamp=sensorData[sensorId].timestamp;

         $.ajax({
            url: dataurl,
             data: ({sensorId : sensorId, timeStamp:timestamp, maxLength:$('#maxlength_'+sensorId).val()}),
            method: 'GET',
            dataType: 'json',
            success: function(data){
                onDataReceived(data, sensorId)
            }
        });
     }

     function onDataReceived(data, sensorId){
        updateSensorVars(sensorId, data);
        var obj = [{label: sensorData[sensorId].type, data: sensorData[sensorId].data}];
        plotData(obj, sensorId)


    }

    function updateSensorVars(sensorId,data){
        if(!sensorData[sensorId]){
            sensorData[sensorId] = {data:data.series, type:data.type, timestamp:data.timestamp};
        }
        else{
            if(data.series) {
		        var maxLength=$('#maxlength_'+sensorId).val();
                for (var i = 0; i < data.series.length; i++) {
					var l = sensorData[sensorId].data.push(data.series[i])		
					if(l>maxLength)
						sensorData[sensorId].data.splice(0,l-maxLength);
				}
			}
			sensorData[sensorId].timestamp = data.timestamp
        }
    }

    function plotData(data, sensorId){
        //alert(data[0].data);
         var placeholder = $("#placeholder_"+sensorId);

        $.plot(placeholder, data, options);
    }
 });
