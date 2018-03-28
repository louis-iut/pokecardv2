package fr.iut.iem.pokecard.ui.listener

/**
 * Created by QuentinGenevois on 27/03/2018.
 */
interface MainNavigatorListener {
    fun launchPokedexView()
    fun launchUserPokedexView()
    fun launchUsersView()
    fun launchGiftView()
    fun launchPokemonDetails(pokemonID : Int)
}