package com.example.tuanh.wordbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tuanh.wordbook.R.id.*
import com.example.tuanh.wordbook.model.InformCard
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_new_word.*
import kotlinx.android.synthetic.main.coin_layout.*

class AddNewWordActivity : AppCompatActivity() {

    lateinit var mData : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_word)

        mData = FirebaseDatabase.getInstance().reference

        save.setOnClickListener {
            addNewWord()

        }
    }

    private fun addNewWord() {
        // create a new class

        // create new node on firebase
        val new = mData.child(Constants.FIREBASE_ITEM).push()
        val item: InformCard = InformCard(new.key,Word.text.toString(),Mean.text.toString(),Trans.text.toString())
        // set value for attribute of class
//        item.ID = new.key
//        item.Word = txtWord.text.toString()
//        item.Mean = txtMean.text.toString()
//        item.Transcription = Trans.text.toString()
        // add hinh anh nua
        new.setValue(item)
//        Word.setText("")
//        Mean.setText("")
//        Trans.setText("")

        Toast.makeText(this, "add new word success", Toast.LENGTH_SHORT).show()
    }
}
