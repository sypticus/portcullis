package portcullis

import com.portcullis.Mote
import com.portcullis.User
import com.portcullis.Sensor

class MoteController {
    def moteService
    def springSecurityService
    def index = {
        def user = User.get(springSecurityService.principal.id)
          def motes = user.motes?.sort{it.mid}
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
    def deleteMote={
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.id, user)
        moteService.deleteMote(mote)
        flash.message = "Mote Deleted!"
        redirect action: 'index', controller: 'mote'
    }
    def sensors = {
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.id, user)
        def sensors = mote.sensors?.sort{it.sid}
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
    def editSensor = {
        def user = User.get(springSecurityService.principal.id)
         def mote = Mote.findByIdAndUser(params.moteId, user)
        def sensor = Sensor.findByIdAndMote(params.id, mote)
        [sensor:sensor, mote:mote]
    }

    def updateSensor = {
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.moteId, user)
        def sensor = Sensor.findByIdAndMote(params.id, mote)
        moteService.updateSensor(sensor, params)
          redirect action: 'sensors', controller: 'mote', id: mote.id
    }

    def deleteSensor = {
       def user = User.get(springSecurityService.principal.id)
       def mote = Mote.findByIdAndUser(params.moteId, user)
       def sensor = Sensor.findByIdAndMote(params.id, mote)
       moteService.deleteSensor(sensor)
        redirect action: 'sensors', controller: 'mote', id: mote.id

    }

    def results={
        def user = User.get(springSecurityService.principal.id)
        def mote = Mote.findByIdAndUser(params.moteId, user)
        [mote:mote]
    }


}
