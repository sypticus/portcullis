package portcullis

import com.portcullis.Mote
import com.portcullis.User

class MoteController {
    def moteService
    def springSecurityService
    def index = {
        def user = User.get(springSecurityService.principal.id)
          def motes = user.motes
        println user
        println motes
          [user:user, motes:motes]

    }
    def updateMote = {
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.id, user)
        moteService.updateMote(mote, params)
        flash.message = "Mote Updated!"
        redirect action: 'index', controller: 'mote'
    }

    def config = {
         def user = User.get(springSecurityService.principal.id)
        [mote: Mote.findByIdAndUser(params.id, user)]
    }
    def addMote = {
        def user = User.get(springSecurityService.principal.id)
        moteService.createMote(user, params)
        flash.message = "Mote Added!"
        redirect action: 'index', controller: 'mote'
    }
    def newMote = {

    }
    def sensors = {
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.id, user)
        def sensors = mote.sensors
        [mote:mote, sensors:sensors]
    }

    def newSensor ={
        def user = User.get(springSecurityService.principal.id)
        [mote:Mote.findByIdAndUser(params.id, user)]
    }
    def addSensor = {
        println params.sensorType
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.id, user)
        moteService.createSensor(mote, params)
        flash.message = "Sensor Added!"
        redirect action: 'sensors', controller: 'mote', id: mote.id
    }
}
