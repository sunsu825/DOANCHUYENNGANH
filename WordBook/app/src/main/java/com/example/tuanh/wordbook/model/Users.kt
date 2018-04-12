package com.example.tuanh.wordbook.model

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by TUANH on 05/04/2018.
 */
@IgnoreExtraProperties
class Users {
    var id: String? = null
    var name: String? = null
    var email: String? = null

    constructor() {

    }

    constructor(Id: String?,name: String?, email: String?) {
        this.id = Id
        this.name = name
        this.email = email
    }
}