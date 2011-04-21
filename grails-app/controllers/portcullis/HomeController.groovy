package portcullis

import grails.converters.XML
import grails.plugins.springsecurity.Secured
import com.portcullis.User
import com.portcullis.SensorState
import com.portcullis.Sensor
import grails.converters.JSON
import com.portcullis.Mote
import com.portcullis.HomeSensor

class HomeController {
    def springSecurityService
    def moteService
    @Secured(['ROLE_USER'])
    def index = {

        def user = User.get(springSecurityService.principal.id)
        def sensors = HomeSensor.findAllByUser(user)*.sensor.sort{it.dateCreated}
         [user:user, sensors:sensors]
    }

    def getStates={
        def sensor = Sensor.get(params.sensorId)

        def data = moteService.getSensorStates(sensor, params)

        render data as JSON

    }
    def removeFromHome={
        def user = User.get(springSecurityService.principal.id)
        def sensor = Sensor.get(params.id)
        moteService.removeSensorFromHome(sensor, user)
         redirect action: 'index', controller: 'home'
    }

    def addToHome={
        def user = User.get(springSecurityService.principal.id)
        def sensor = Sensor.get(params.id)
        assert(sensor.mote.user == user)
        moteService.addSensorToHome(sensor, user)
       redirect action: 'results', controller: 'mote', id: sensor.mote.id
    }

}
