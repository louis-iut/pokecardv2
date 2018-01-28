package fr.iut.iem.pokecard.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by louis on 28/01/2018.
 */
data class User(
        @field:SerializedName("id") val id: Int?,
        @field:SerializedName("facebook_id") val facebooId: String,
        @field:SerializedName("pseudo") val pseudo: String?) {
}