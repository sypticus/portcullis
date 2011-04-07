package portcullis

import grails.converters.XML
import com.portcullis.User
import com.portcullis.Mote
import com.portcullis.Sensor
import com.portcullis.SensorState

class MessageService {

    static transactional = true

    def receiveCall(xml) {
        def data = processMessage(xml)
        if(!data){
            println "NO DATA!"
            return
        }

    }

    def getUser(data){
        User.findById(data.id.toString() as long)
    }

    def processMessage(xml){
        def clientData = parseXml(xml)
        processData(clientData)
    }

    def processData(clientData){          //TODO:REWRITE THIS TO BE FASTER
        int userId = clientData.@key.toString() as long
        def user = User.findById(userId)
        clientData.mote.each{m ->
            def mote = user.motes.find{it.mid.toString() == m.@mid.toString()}
            m.sensor.each{s->
                def sensor = mote?.sensors?.find{it.sid.toString() == s.@sid.toString()}
                createSensorState(sensor, s, m.@timestamp.toString())
            }
        }

    }

    def createSensorState(sensor, value, timestamp){
        def state = SensorState.findBySensorAndTimeStamp(sensor, timestamp)
        if(!state){
            state = new SensorState(sensor: sensor, timeStamp: timestamp.toString())
        }
        state.value = value.toString()
        state.save(flush:true, failOnError:true)
    }

    def parseXml(xml){
        XML.parse(xml)
    }


}
