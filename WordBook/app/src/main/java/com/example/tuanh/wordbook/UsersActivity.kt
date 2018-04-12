package com.example.tuanh.wordbook

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tuanh.wordbook.model.Account
import com.example.tuanh.wordbook.model.Users
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    lateinit var mData: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        mData = FirebaseDatabase.getInstance().reference

        btnSignUp.setOnClickListener{

                writeUserC2()


        }

        btnSignIn.setOnClickListener {
            // use this or applictionContext
            goHome()
        }
    }

    private fun writeUserC2() {
        val accout = Account.create()
        accout.user = editUser.text.toString()
        accout.password = editPass.text.toString()

        val newData = mData.child("newAcout").push()
        accout.id = newData.key
        newData.setValue(accout)

        Toast.makeText(this, "Crete new accout success!!", Toast.LENGTH_SHORT).show()
    }

    private fun writeNewUser(ID: String,user: String, email: String) {

        var user: Users = Users(ID,user,email)
        mData.child("user").setValue(user)
    }

    private fun goHome() {
        val intent : Intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
