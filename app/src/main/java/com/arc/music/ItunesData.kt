package com.arc.music

data class ItunesData(
    val resultCount: Int?,
    val results:List<MusicData>?)

data class MusicData(
    val artistName: String?,
    val collectionName: String?,
    val trackName: String?,
    val previewUrl: String?,
    val artworkUrl130: String?
)
