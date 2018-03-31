package fr.iut.iem.pokecard.ui.view

import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.PokemonDetails

/**
 * Created by QuentinGenevois on 28/03/2018.
 */
interface PokemonDetailsView {
    fun updateUI(pokemon: Pokemon, pokemonDetails : PokemonDetails)
}