package portcullis

import grails.converters.XML
import grails.plugins.springsecurity.Secured
import com.portcullis.User
import com.portcullis.SensorState
import com.portcullis.Sensor
import grails.converters.JSON
import com.portcullis.Mote

class HomeController {
    def springSecurityService
    def moteService
    @Secured(['ROLE_USER'])
    def index = {
        def sensors = null
        def mote = null
        def user = User.get(springSecurityService.principal.id)
         def motes = user.motes
         if(params.moteId){
            mote = Mote.get(params.moteId)
            sensors = moteService.getSensorStates(mote, params)
         }
        println sensors
         [user:user, motes:motes, sensors:sensors, mote:mote, max:params.max?params.max:50]
    }

    def getStates={
        def sensor = Sensor.get(params.sensorId)

        def series = SensorState.findAllBySensorAndTimeStampGreaterThan(sensor, params.timeStamp as long, [sort: "timeStamp",order: "asc"]).collect{[it.timeStamp, it.value as int]}
        def data = [
                    series:series,
                name:sensor.name
                ]

        println data as JSON
        render data as JSON

    }

}
