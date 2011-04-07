package portcullis

import grails.converters.XML
import grails.plugins.springsecurity.Secured
import com.portcullis.User

class HomeController {
    def springSecurityService
    @Secured(['ROLE_USER'])
    def index = {
         def user = User.get(springSecurityService.principal.id)
         def motes = user.motes
         [user:user, motes:motes]



    }
}
