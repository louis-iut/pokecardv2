package fr.iut.iem.pokecard.data.model

import com.google.gson.annotations.SerializedName
import fr.iut.iem.pokecard.PokeCardApp

/**
 * Created by QuentinGenevois on 28/03/2018.
 */
class PokemonDetails(
        @field:SerializedName("id") val id: Int,
        @field:SerializedName("habitat") val habitat: String,
        @field:SerializedName("color") val color: String,
        @field:SerializedName("description") val description: String) {
}