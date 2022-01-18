package com.arc.music

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.arc.music.databinding.ActivityMainBinding

class MainPresenter():MainContract.Presenter {

    lateinit var cView: MainContract.View
    override fun setTargetView(contractView: MainContract.View) {
        cView = contractView
    }

    override fun getMusics(query:String?) {
        val querySearch = query?.replace(" ","+")

        querySearch?.let {
            if(MusicValidator.validateQuerySearchMusic(it)){
                AndroidNetworking.get("https://itunes.apple.com/search?term=$querySearch&country=id&limit=10")
                    .build()
                    .getAsObject(ItunesData::class.java, object: ParsedRequestListener<ItunesData>{
                        override fun onResponse(response: ItunesData?) {
                            cView.successGetListMusic(response)
                        }

                        override fun onError(anError: ANError?) {
                            cView.failedGetListMusic(anError?.message)
                        }
                    })
            }
        }


    }

}