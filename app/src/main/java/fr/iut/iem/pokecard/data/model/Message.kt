package fr.iut.iem.pokecard.data.model

import com.google.gson.annotations.SerializedName

data class Message(
        @field:SerializedName("status_code") val code: Int?,
        @field:SerializedName("message") val message: String
)