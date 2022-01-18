package com.arc.music

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.arc.music.databinding.ActivityMainBinding
import com.arges.sepan.argmusicplayer.Models.ArgAudio

class MainActivity : AppCompatActivity(),MusicAdapter.musicListener,MainContract.View {

    private lateinit var mainBinding: ActivityMainBinding

    lateinit var presenter: MainPresenter

    var listMusicData = ArrayList<MusicData>()
    val musicAdapter = MusicAdapter(listMusicData,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        presenter = MainPresenter()
        presenter.setTargetView(this)

        mainBinding.rvListMusic?.apply {
            adapter = musicAdapter
        }

        //presenter.getMusics("dua lipa")

        mainBinding.etSongTitle.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if(it.length > 5){
                        presenter.getMusics(s.toString())
                    }
                }

            }

        })
    }

    override fun successGetListMusic(dataItunesMusic: ItunesData?) {
        listMusicData.clear()
        dataItunesMusic?.results?.let {
            listMusicData.addAll(it)
        }
        musicAdapter.notifyDataSetChanged()
    }

    override fun failedGetListMusic(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(pos: Int) {
        val dataMusic = listMusicData[pos]
        val audio:ArgAudio = ArgAudio.createFromURL(dataMusic.artistName,dataMusic.trackName,dataMusic.previewUrl)
        mainBinding.argmusicplayer.stop()
        mainBinding.argmusicplayer.play(audio)
    }
}