package com.portcullis

class Role {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
    static getUserRole() {
        return Role.findByAuthority('ROLE_USER')

    }
}
