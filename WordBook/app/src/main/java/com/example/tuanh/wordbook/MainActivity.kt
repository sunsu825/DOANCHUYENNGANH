package com.example.tuanh.wordbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.tuanh.wordbook.model.InformCard
import com.example.tuanh.wordbook.model.WordsAdapter
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.coin_layout.*


class MainActivity : AppCompatActivity() {

    //            InformCard("1","Football","bong da","football"),
//            InformCard("2","Flight","chuyen bay","flight"),
//            InformCard("3","Football","bong da","football"),
//            InformCard("4","Flight","chuyen bay","flight"),
//            InformCard("5","Football","bong da","football")
    private lateinit var mDataBase: DatabaseReference
    private lateinit var adapter: WordsAdapter
    private var ls: MutableList<InformCard> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create reference for new word on firebase
        mDataBase = FirebaseDatabase.getInstance().getReference("Collection_Words")
        // get data firebase
        getdataFirebase()
        // reverselayout define items from down to up if false and else
        val linearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        // define recyclerview is LinearLayout type
        recycler_view.layoutManager = linearLayoutManager
        adapter = WordsAdapter(this,ls)
        recycler_view.adapter = adapter

        btn_insert.setOnClickListener {
            val intent: Intent = Intent(this, AddNewWordActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getdataFirebase() {
        var childedValue = object : ChildEventListener{
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                var valu = p0.getValue(InformCard::class.java)
                ls.add(valu!!)
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        mDataBase!!.addChildEventListener(childedValue)
    }
}


