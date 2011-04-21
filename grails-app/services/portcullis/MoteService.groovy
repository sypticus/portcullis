package portcullis

import com.portcullis.Mote
import com.portcullis.Sensor
import com.portcullis.SensorType
import com.portcullis.SensorState
import com.portcullis.HomeSensor

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
        sensor.name = params.name
        sensor.sensortype = SensorType.getFromString(params.sensorType)
        sensor.mote = mote
        sensor.save(flush:true, failOnError:true)
    }
    def deleteMote(Mote mote){
        mote.sensors?.collect{Sensor s ->
            {->
                SensorState.findAllBySensor(s).each{it.delete()}
                HomeSensor.findAllBySensor(s).each {it.delete()}
                mote.removeFromSensors(s)
                s.delete(flush:true)
            }
        }*.call()

        mote.delete()
    }

    def updateSensor(sensor, params){
         sensor.sid = params.sid
        sensor.name = params.name
        sensor.sensortype = SensorType.getFromString(params.sensorType)
        sensor.save(flush:true)
    }

    def getSensorStates(sensor, params){
        def series = SensorState.findAllBySensorAndTimeStampGreaterThan(sensor, (params.timeStamp as long) * 1000, [sort: "timeStamp",order: "asc"]).collect{[it.timeStamp, it.value as int]}
        def data = [
                      series:series,
                  name:sensor.name,
                  type: sensor.sensortype.toString()
                  ]

        data
    }

    def addSensorToHome(sensor, user){
        def homeSensor
        homeSensor = HomeSensor.findBySensorAndUser(sensor, user)
        if(homeSensor) return
        new HomeSensor(sensor: sensor, user: user).save(flush:true, failOnError:true)
    }

    def removeSensorFromHome(sensor, user){
        def homeSensor = HomeSensor.findBySensorAndUser(sensor, user)
        homeSensor?.delete(flush:true)
    }

     def deleteSensor(sensor){
        HomeSensor.findAllBySensor(sensor).each{it.delete()}
        SensorState.findAllBySensor(sensor).each{it.delete()}
        sensor.delete(flush:true)
    }
}
