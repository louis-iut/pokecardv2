package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable

/**
 * Created by louis on 28/01/2018.
 */
interface CacheManager {

    fun getCurrentUser(): User?
    fun setCurrentUser(user: User)

    fun getUsers(): List<User>
    fun setUsers(users: List<User>)

    fun getPokemon(id: Int):Pokemon?
    fun setPokemon(pokemon: Pokemon)

    fun getPokemons(page: Int, offset: Int): List<Pokemon>?
    fun setPokemons(pokemons : List<Pokemon>)

    fun getUserPokemons(): List<Pokemon>?
    fun setUserPokemons(pokemons: List<Pokemon>)
}