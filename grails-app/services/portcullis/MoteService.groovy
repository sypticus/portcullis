package portcullis

import com.portcullis.Mote
import com.portcullis.Sensor
import com.portcullis.SensorType
import com.portcullis.SensorState

class MoteService {

    static transactional = true

    def updateMote(mote, params) {
        mote.name = params.name
        mote.mid = params.mid
        mote.save(flush:true, failOnError:true)
    }
    def createMote(user, params){
        def mote = new Mote()
        mote.name = params.name
        mote.mid = params.id
        mote.user = user
        mote.save(flush:true, failOnError:true)
    }
    def createSensor(mote, params){
        def sensor = new Sensor()
        sensor.sid = params.sid
        sensor.name = params.sid
        sensor.sensortype = SensorType.getFromString(params.sensorType)
        sensor.mote = mote
        sensor.save(flush:true, failOnError:true)
    }
    def deleteMote(Mote mote){
        mote.sensors?.collect{Sensor s ->
            {->
                SensorState.findAllBySensor(s).each{it.delete()}
                mote.removeFromSensors(s)
                s.delete(flush:true)
            }
        }*.call()

        mote.delete()
    }

    def updateSensor(sensor, params){
         sensor.sid = params.sid
        sensor.name = params.sid
        sensor.sensortype = SensorType.getFromString(params.sensorType)
        sensor.save(flush:true)
    }
     def deleteSensor(sensor){
        SensorState.findAllBySensor(sensor).each{it.delete()}
        sensor.delete(flush:true)
    }
}
