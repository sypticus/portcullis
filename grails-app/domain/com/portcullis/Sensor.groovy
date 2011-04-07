package com.portcullis

class Sensor {

    Date dateCreated
    Date lastUpdated
    String name
    SensorType sensortype
    String sid
    Mote mote
    static constraints = {
        sensortype(nullable: true)
    }
}
