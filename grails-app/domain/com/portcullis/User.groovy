package com.portcullis

class User {

	String username
	String password
    Date dateCreated
    Date lastUpdated
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    static hasMany=[motes:Mote]

	static constraints = {
		username blank: false, unique: true
		password blank: false
    }

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}
}
