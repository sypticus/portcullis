package portcullis

import grails.converters.XML
import grails.plugins.springsecurity.Secured
import com.portcullis.User
import com.portcullis.SensorState
import com.portcullis.Sensor
import grails.converters.JSON

class HomeController {
    def springSecurityService
    @Secured(['ROLE_USER'])
    def index = {
         def user = User.get(springSecurityService.principal.id)
         def motes = user.motes
         [user:user, motes:motes]
    }

    def getStates={
        def sensor = Sensor.get(params.sensorId)
        def states = SensorState.findAllBySensorAndTimeStampGreaterThan(sensor, params.timeStamp as long, [sort: "timeStamp",order: "asc"])
        render states as JSON

    }

}
