<head>
    <meta name="layout" content="main"/>
      <g:javascript library="flot/jquery.flot" />
    <title>Sensor Data</title>
</head>
 <div class="breadCrumbs">
    <ul>
        <li><g:link action="index" controller="mote" >Motes</g:link></li>
        <li>Sensor Data</li>
    </ul>
</div>
 <div class="pageTitle">Sensor Data</div>
<div class="subTitle">${mote.name}</div>
<div class="mainContent">
<g:each var="sensor" in="${mote.sensors}">
    <g:hiddenField class="sensorHidden" name="sensor${sensor.id}" value="${sensor.id}"/>
    <div id="placeholder_${sensor.id}" style="width:600px;height:300px;"></div>
</g:each>
    <button id="test">test</button>

</div>

<script type="text/javascript">

 $(function () {
    dataurl = "../home/getStates";

    var options = {
        lines: { show: true },
        points: { show: true },
        xaxis: { tickDecimals: 0, tickSize: 1 }
    };

    $('#test').click(function(){
        $(".sensorHidden").each(function(index){
            updateSensorData(this.value);
        });

    });

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
         name = data.name;
        var obj = [{label: name, data: series}]
        plotData(obj, sensorId)


    };

    function plotData(data, sensorId){
         var placeholder = $("#placeholder_"+sensorId);
        $.plot(placeholder, data, options);
    }
 });


</script>