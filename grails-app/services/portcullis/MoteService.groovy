package portcullis

import com.portcullis.Mote
import com.portcullis.Sensor
import com.portcullis.SensorType

class MoteService {

    static transactional = true

    def updateMote(moteId, params) {
        def mote = Mote.get(moteId)
        mote.name = params.name
        mote.mid = params.id
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
}
