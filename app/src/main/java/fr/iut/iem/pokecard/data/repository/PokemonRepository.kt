package fr.iut.iem.pokecard.data.repository

import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPI
import fr.iut.iem.pokecard.data.model.Pokemon
import io.reactivex.Observable

/**
 * Created by louis on 27/01/2018.
 */
class PokemonRepository(private var pokeAPI: PokeAPI) {

    fun getPokemonByID(id: Int): Observable<Pokemon> {
        return pokeAPI.getPokemonByID(id)
    }

    fun getPokemons(from: Int, to: Int): Observable<List<Pokemon>> {
        return pokeAPI.getPokemons(from, to)
    }
}