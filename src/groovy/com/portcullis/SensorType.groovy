package com.portcullis

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 4/6/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public enum SensorType {
    Temperature("Temperature"),
    Voltage("Voltage"),
    PH("PH"),
    Light("Light")
    private final String value

    static getFromString(string){
         return SensorType.valueOf(string);
    }

    SensorType(String value){
      this.value = value;
     }

     String toString() {
      value
     }
     public String value() {
        return name();
    }
     String getKey() {
      name()
 }
}