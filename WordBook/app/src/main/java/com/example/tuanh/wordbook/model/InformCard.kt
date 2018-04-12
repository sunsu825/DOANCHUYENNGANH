package com.example.tuanh.wordbook.model

/**
 * Created by TUANH on 04/04/2018.
 */
class InformCard {
    public var id: String? = null
//        get() = ID
//        set(value) {ID = value}
    public var word: String? = null
//        get() = Word
//        set(value) {Word = value}
    public var mean: String? = null
//        get() = Mean
//        set(value) {Mean = value}
    public var transcription: String? = null
//        get() = Transcription
//        set(value) {Transcription = value}
    //    public var Img: Int
//        get() = img
//        set(value) {Img = value}

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(Message.class)
    }

    constructor(id: String,word: String, mean: String, transcription: String) {
        this.id = id
        this.word = word
        this.mean = mean
        this.transcription = transcription
        // this.img = img
    }



}