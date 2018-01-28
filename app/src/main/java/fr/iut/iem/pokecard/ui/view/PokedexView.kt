package fr.iut.iem.pokecard.ui.view

import fr.iut.iem.pokecard.data.model.Pokemon

/**
 * Created by louis on 28/01/2018.
 */
interface PokedexView {
    fun updateUI(pokemons : List<Pokemon>)
}