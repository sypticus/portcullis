import com.portcullis.Role

class BootStrap {

    def init = { servletContext ->
        if(Role.count()==0){
            new Role(authority: 'ROLE_USER').save(flush:true, failOnError:true)
        }
    }
    def destroy = {
    }
}
