package fr.iut.iem.pokecard.data.repository

import android.os.Build.VERSION_CODES.O
import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function

/**
 * Created by louis on 27/01/2018.
 */
class PokemonRepository(
        private val pokeAPIManager: PokeAPIManager,
        private val cacheManager: CacheManager
) {

    fun getPokemonByID(id: Int): Observable<Pokemon> {
        return pokeAPIManager.getPokemonByID(id)
    }

    fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>> {
        return getPokemonsFromCache(page, offset)
                .onErrorResumeNext(Function { getPokemonsFromAPI(page, offset) })
    }

    fun getUserPokemons(id: Int): Observable<List<Pokemon>> {
        return pokeAPIManager.getUserPokemons(id)
    }

    private fun getPokemonsFromCache(page: Int, offset: Int): Observable<List<Pokemon>> {
        var pokemons: List<Pokemon> = cacheManager.getPokemons(page, offset)
                ?: return Observable.error(Throwable("pokedex empty"))

        return Observable.fromArray(pokemons)
    }

    private fun getPokemonsFromAPI(page: Int, offset: Int): Observable<List<Pokemon>> {
        return pokeAPIManager.getPokemons(page, offset).doOnNext { t -> setPokemonsOnCache(t) }
    }

    private fun setPokemonsOnCache(pokemons: List<Pokemon>) {
        cacheManager.setPokemons(pokemons)
    }
}