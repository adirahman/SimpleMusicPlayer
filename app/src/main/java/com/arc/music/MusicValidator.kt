package com.arc.music

object MusicValidator {

    /**
     * the input is not valid if
     * ...query less then 5 char
     * ...query is empty or null
     * ...contains more that 2+
     */
    fun validateQuerySearchMusic(query:String):Boolean{
        if(query.isEmpty()){
            return false
        }
        if(query.length < 5){
            return false
        }
        if(query.contains("++")){
            return false
        }
        return true
    }
}