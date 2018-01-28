package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable

/**
 * Created by louis on 27/01/2018.
 */
interface PokeAPIManager {

    fun getUsers(): Observable<List<User>>

    fun getPokemonByID(id: Int): Observable<Pokemon>
    fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>>
    fun login(user: User): Observable<User>
    fun signUp(user: User): Observable<User>
}