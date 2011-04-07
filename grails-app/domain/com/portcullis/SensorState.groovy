package com.portcullis

class SensorState {
    Date dateCreated
    Date lastUpdated
    Sensor sensor
    String value
    long timeStamp
    static constraints = {
        value(nullable: true)
    }
}
