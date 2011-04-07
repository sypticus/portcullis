package com.portcullis

class Mote {


    String name
    User user
    Date dateCreated
    Date lastUpdated
    String mid
     static hasMany=[sensors:Sensor]
    static belongsTo = User
    static constraints = {

    }
}
