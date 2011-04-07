package portcullis

import grails.converters.XML

class MessageController {

    def index = { }
    def post = {
        println "RECEIVED CALL"
        println params
        def service = new MessageService()
        service.receiveCall(params.xml)
        render "200"
        return
    }

}
