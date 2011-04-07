package portcullis

import grails.test.*
import com.portcullis.User
import grails.plugins.springsecurity.SpringSecurityService
import com.portcullis.UserRole
import com.portcullis.Role

class UserServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain User
        mockDomain Role
        mockDomain UserRole
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testIsAvailable_returns_true_if_avail() {
        def service = new UserService()
        def results = service.isAvailable('test@test.com')
        assert(results)
    }

    void testIsAvailable_returns_false_if_taken() {
        def service = new UserService()
        def user = new User(username:'test@test.com', password: 'test').save(flush:true, failOnError:true)
        def results = service.isAvailable('test@test.com')
        assertFalse(results)

    }

    void testCreateUser_saves_user_and_encodes_pw(){
        def service = new UserService(
                springSecurityService : [encodePassword:{a->return 'encrypted'},reauthenticate:{a->}]
        )
         new Role(authority: "ROLE_USER").save(flush:true, failOnError:true)
        service.createUser('test@example.com', 'asd')
        def user = User.findByUsername('test@example.com')
        assert(user)
        assert(user.password)
        assert(user.password=='asd')

    }
     void testCreateUser_adds_role(){
        def service = new UserService(
                springSecurityService : [encodePassword:{a->return 'encrypted'},reauthenticate:{a->}]

        )
        new Role(authority: "ROLE_USER").save(flush:true, failOnError:true)
        service.createUser('test@example.com', 'asd')
        def user = User.findByUsername('test@example.com')
        assert(user)
        def userRole = UserRole.findByUser(user)
        assert(userRole)
        assert(userRole.role.authority == "ROLE_USER")

    }
}
