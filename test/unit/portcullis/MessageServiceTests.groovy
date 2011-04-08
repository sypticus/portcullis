package portcullis

import grails.test.*
import grails.converters.JSON
import org.codehaus.groovy.grails.plugins.codecs.JavaScriptCodec
import com.portcullis.SensorState
import grails.converters.XML
import com.portcullis.User
import com.portcullis.Mote
import com.portcullis.Sensor
import com.portcullis.SensorType

class MessageServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        loadCodec(JavaScriptCodec)
        mockDomain User
        mockDomain Mote
        mockDomain Sensor
        mockDomain SensorState
    }

    protected void tearDown() {
        super.tearDown()
    }

    void test_parseXml_parses_xml() {
        def service = new MessageService()
        def results = service.parseXml(fakeXml())
        assert(results.@key=="123")
        assert(results.mote[0].@mid == "2")
        assert(results.mote[0].sensor[0] == "98")
        assert(results.mote[1].sensor[2] == "6")

    }

    def fakeXml(){
         def testXML="""
            <data key="123">
                <mote mid = "2" timestamp = "1234567">
                    <sensor sid = "a0">98</sensor>
                    <sensor sid = "a1">12</sensor>
                    <sensor sid = "a2">9</sensor>
                    <sensor sid = "a3">100</sensor>
                </mote>
                <mote mid = "3" timestamp = "1234567">
                    <sensor sid="a0">93</sensor>
                    <sensor sid = "a1">10</sensor>
                    <sensor sid = "a2">6</sensor>
                    <sensor sid = "a3">90</sensor>
                </mote>
            </data>
        """
        return testXML
    }

    void test_recieveCall_saves_sensor_data(){

         def tas =""
        def user = new User(username:'test', password: 'test2').save(flush:true, failOnError:true)
        def service = new MessageService()
        def mote1 = new Mote(mid:'2', name:'test', user:user).save(flush:true, failOnError:true)
    //    def mote2 = new Mote(mid:'3', name:'test2', user:user).save(flush:true, failOnError:true)
        def sensor1 = new Sensor(sid: 'a0', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor2 = new Sensor(sid: 'a1', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor3 = new Sensor(sid: 'a2', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor4 = new Sensor(sid: 'a3', mote:mote1, name:'test1').save(flush:true, failOnError:true)
      /*  def sensor5 = new Sensor(sid: 'a0', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor6 = new Sensor(sid: 'a1', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor7 = new Sensor(sid: 'a2', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor8 = new Sensor(sid: 'a3', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        */



        mote1.addToSensors(sensor1)
        mote1.addToSensors(sensor2)
        mote1.addToSensors(sensor3)
        mote1.addToSensors(sensor4)

      /*  mote2.addToSensors(sensor5)
        mote2.addToSensors(sensor6)
        mote2.addToSensors(sensor7)
        mote2.addToSensors(sensor8)
        */
        user.addToMotes(mote1)
       // user.addToMotes(mote2)

        def results = service.receiveCall(fakeXml2())
        assert SensorState.findBySensor(sensor1).value == "98"
    }

    void test_processData_calls_save_with_values(){
        def tas =""
        def user = new User(username:'test', password: 'test2').save(flush:true, failOnError:true)
        def service = new MessageService()
        service.metaClass.createSensorState = {a,b,c -> tas = "${a.sid.toString()}${b}${c}"; return}
        def mote1 = new Mote(mid:'2', name:'test', user:user).save(flush:true, failOnError:true)
        def mote2 = new Mote(mid:'3', name:'test2', user:user).save(flush:true, failOnError:true)
        def sensor1 = new Sensor(sid: 'a0', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor2 = new Sensor(sid: 'a1', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor3 = new Sensor(sid: 'a2', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor4 = new Sensor(sid: 'a3', mote:mote1, name:'test1').save(flush:true, failOnError:true)
        def sensor5 = new Sensor(sid: 'a0', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor6 = new Sensor(sid: 'a1', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor7 = new Sensor(sid: 'a2', mote:mote2, name:'test1').save(flush:true, failOnError:true)
        def sensor8 = new Sensor(sid: 'a3', mote:mote2, name:'test1').save(flush:true, failOnError:true)




        mote1.addToSensors(sensor1)
        mote1.addToSensors(sensor2)
        mote1.addToSensors(sensor3)
        mote1.addToSensors(sensor4)

        mote2.addToSensors(sensor5)
        mote2.addToSensors(sensor6)
        mote2.addToSensors(sensor7)
        mote2.addToSensors(sensor8)

        user.addToMotes(mote1)
        user.addToMotes(mote2)
        println User.count()
        println user.id
        def data = XML.parse(fakeXml2())
        service.processData(data)
        assert(tas=='a3901234567')
    }

     def fakeXml2(){
         def testXML="""
            <data key="1">
                <mote mid = "2" timestamp = "1234567">
                    <sensor sid = "a0">98</sensor>
                    <sensor sid = "a1">12</sensor>
                    <sensor sid = "a2">9</sensor>
                    <sensor sid = "a3">100</sensor>
                </mote>
                <mote mid = "3" timestamp = "1234567">
                    <sensor sid="a0">93</sensor>
                    <sensor sid = "a1">10</sensor>
                    <sensor sid = "a2">6</sensor>
                    <sensor sid = "a3">90</sensor>
                </mote>
            </data>
        """
        return testXML
    }
}

