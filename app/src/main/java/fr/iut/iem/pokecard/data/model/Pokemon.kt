package fr.iut.iem.pokecard.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by louis on 27/01/2018.
 */
data class Pokemon(@field:SerializedName("id") val id: Int,
                   @field:SerializedName("imageURL") val image: String,
                   @field:SerializedName("name") val name: String)