package fr.iut.iem.pokecard.data.repository

import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.manager.`interface`.DBManager
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.PokemonDetails
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by louis on 27/01/2018.
 */
class PokemonRepository(
        private val pokeAPIManager: PokeAPIManager,
        private val cacheManager: CacheManager,
        private val dbManager: DBManager
) {
    fun getPokemonDetails(id: Int): Observable<PokemonDetails> {
        return pokeAPIManager.getPokemonDetailsByID(id)
    }

    fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>> {
        return getPokemonsFromCache(page, offset)
                .onErrorResumeNext(Function {
                    getPokemonsFromAPI(page, offset)
                })
    }

    fun getPokemon(id: Int): Observable<Pokemon> {
        val pokemon = cacheManager.getPokemon(id)
                ?: return Observable.error(Throwable("pokedex empty"))

        return Observable.just(pokemon)
    }

    fun getUserPokemons(id: Int): Observable<List<Pokemon>> {
        return getUserPokemonFromCache()
                .onErrorResumeNext(Function { getUserPokemonsFromDB() })
                .onErrorResumeNext(Function { getUserPokemonsFromApi(id) })
    }

    private fun getPokemonsFromCache(page: Int, offset: Int): Observable<List<Pokemon>> {
        val pokemons = cacheManager.getPokemons(page, offset)

        if (pokemons == null || pokemons.isEmpty()) {
            return Observable.error(Throwable("pokedex empty"))
        }

        return Observable.fromArray(pokemons)
    }

    private fun getPokemonsFromAPI(page: Int, offset: Int): Observable<List<Pokemon>> {
        return pokeAPIManager.getPokemons(page, offset).doOnNext {
            setPokemonsOnCache(it)
        }.map { cacheManager.getPokemons(page, offset) }
    }

    private fun setPokemonsOnCache(pokemons: List<Pokemon>) {
        cacheManager.setPokemons(pokemons)
    }

    private fun getUserPokemonFromCache(): Observable<List<Pokemon>> {

        val pokemons = cacheManager.getUserPokemons()

        if (pokemons == null || pokemons.isEmpty()) {
            return Observable.error(Throwable("user pokedex empty"))
        }

        return Observable.fromArray(pokemons)
    }

    fun getUserPokemonsFromApi(id: Int): Observable<List<Pokemon>> {
        return pokeAPIManager.getUserPokemons(id).doOnNext {
            setUserPokemonsOnDB(it)
            setUserPokemonOnCache(it)
        }
    }

    private fun setUserPokemonOnCache(pokemons: List<Pokemon>) {
        cacheManager.setUserPokemons(pokemons)
    }

    private fun getUserPokemonsFromDB(): Observable<List<Pokemon>> {
        val pokemons = dbManager.getUserPokemons()

        if (pokemons == null || pokemons.isEmpty()) {
            return Observable.error(Throwable("user pokedex empty"))
        }

        cacheManager.setUserPokemons(pokemons)

        return Observable.fromArray(pokemons)
    }

    private fun setUserPokemonsOnDB(pokemons: List<Pokemon>) {
        dbManager.setUserPokemons(pokemons)
    }
}