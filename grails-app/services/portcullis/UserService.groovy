package portcullis

import com.portcullis.User
import org.springframework.security.authentication.encoding.ShaPasswordEncoder
import com.portcullis.UserRole
import com.portcullis.Role
import java.util.logging.StreamHandler

class UserService {
    def springSecurityService
    static transactional = true

    def createUser(username, password) {
        def user = new User(
            username: username,
            enabled: true,
	        accountExpired:false,
	        accountLocked: false,
            passwordExpired:false,
            password: password
        ).save(flush:true, failOnError:true)

        def userRole = new UserRole(user: user, role: Role.getUserRole()).save(flush:true, failOnError:true)

    }

    def isAvailable(username){
        def user = User.findByUsername(username)
        return user==null
    }
}
