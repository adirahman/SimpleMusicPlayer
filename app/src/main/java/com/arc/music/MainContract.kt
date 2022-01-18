package com.arc.music

import com.arc.music.databinding.ActivityMainBinding

class MainContract {
    interface View{
        fun successGetListMusic(dataItunesMusic:ItunesData?)
        fun failedGetListMusic(message:String?)
    }
    interface Presenter{
        fun setTargetView(contractView:View)
        fun getMusics(query:String?)
    }
}