package fr.iut.iem.pokecard.ui.listener

import fr.iut.iem.pokecard.data.model.User

/**
 * Created by QuentinGenevois on 27/03/2018.
 */
interface MainNavigatorListener {
    fun launchPokedexView()
    fun launchUserPokedexView()
    fun launchUsersView()
    fun launchGiftView(user: User)
    fun launchPokemonDetails(pokemonID : Int)
}