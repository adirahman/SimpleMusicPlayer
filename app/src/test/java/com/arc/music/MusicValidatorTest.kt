package com.arc.music

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class MusicValidatorTest {

    @Test
    fun `valid input return true`(){
        val result = MusicValidator.validateQuerySearchMusic("dua lipa")
        assertThat(result).isTrue()
    }

    @Test
    fun `query less than 5 character return false`(){
        val result = MusicValidator.validateQuerySearchMusic("dua ")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty query return false`(){
        val result = MusicValidator.validateQuerySearchMusic("")
        assertThat(result).isFalse()
    }

    @Test
    fun `query contain more than 2 + return false`(){
        val result = MusicValidator.validateQuerySearchMusic("dua+++")
        assertThat(result).isFalse()
    }
}