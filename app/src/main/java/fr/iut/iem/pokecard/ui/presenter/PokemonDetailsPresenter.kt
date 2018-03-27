package fr.iut.iem.pokecard.ui.presenter

import android.content.Context
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.repository.PokemonRepository

/**
 * Created by QuentinGenevois on 27/03/2018.
 */
class PokemonDetailsPresenter (
        private var context: Context?
){
    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()
}