package com.example.tuanh.wordbook.model

import android.content.Context
import android.provider.UserDictionary
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tuanh.wordbook.R
import kotlinx.android.synthetic.main.coin_layout.view.*

/**
 * Created by TUANH on 09/04/2018.
 */
class WordsAdapter(context: Context, var items: MutableList<InformCard>): RecyclerView.Adapter<WordsAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // get data base on position
        var inf: InformCard = items[position]

        // set item view base on your view and data model
        var hWord = holder.viewWord
        var hMean = holder.viewMean
        var hTran = holder.viewTran
        var hImg = holder.viewImg

        hWord.text = inf.word
        hMean.text = inf.mean
        hTran.text = inf.transcription
        //hImg.setImageResource(inf.Img)
    }

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder? {
        // set layout for each item
        return MyViewHolder(layoutInflater.inflate(R.layout.coin_layout,parent,false))
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var viewWord = view.txtWord
        var viewMean = view.txtMean
        var viewTran = view.txtTranscription
        var viewImg = view.imgWord
    }


}