package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import io.reactivex.Observable

/**
 * Created by louis on 27/01/2018.
 */
interface PokeAPIManager {
    fun getPokemonByID(id: Int): Observable<Pokemon>
    fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>>
}