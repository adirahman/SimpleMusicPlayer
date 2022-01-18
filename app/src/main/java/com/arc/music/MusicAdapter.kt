package com.arc.music

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arc.music.databinding.RowMusicBinding
import com.bumptech.glide.Glide

class MusicAdapter(val listMusic: List<MusicData>, val listener: musicListener): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>(){

    private lateinit var context: Context

    inner class MusicViewHolder(val rowMusicBinding: RowMusicBinding) : RecyclerView.ViewHolder(rowMusicBinding.root)

    interface musicListener{
        fun onClick(pos:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        context = parent.context
        val binding = RowMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holderMusic: MusicViewHolder, position: Int) {
        with(holderMusic){
            with(listMusic[position]){

                rowMusicBinding.tvArtistName.text = artistName
                rowMusicBinding.tvAlbum.text = collectionName
                rowMusicBinding.tvSongName.text = trackName
                Glide.with(context)
                    .load(artworkUrl130)
                    .into(rowMusicBinding.imageView)
            }
            itemView.setOnClickListener {
                listener.onClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listMusic.size
    }
}