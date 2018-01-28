package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import io.reactivex.Observable

/**
 * Created by louis on 28/01/2018.
 */
interface CacheManager {
    fun getPokemonByID(id: Int):Pokemon?
    fun setPokemon(pokemon: Pokemon)

    fun getPokemons(page: Int, offset: Int): List<Pokemon>?
    fun setPokemons(pokemons : List<Pokemon>)
}