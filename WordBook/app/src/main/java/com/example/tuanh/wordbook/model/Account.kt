package com.example.tuanh.wordbook.model

/**
 * Created by TUANH on 07/04/2018.
 */
public class Account {
    companion object Factory{
        fun create(): Account {
            return Account()
        }
    }
    var id: String? = null
//        get() = id
//        set(value) {
//            id = value
//        }
    var user: String? = null
//        get() = user
//        set(value)  {
//            user = value
//        }
    var password: String? = null
//        get() = password
//        set(value) {
//            password = value
//        }

}