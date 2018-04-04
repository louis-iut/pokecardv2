package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Single

interface DBManager {

    fun getCurrentUser(): Single<User?>
    fun setCurrentUser(user: User)

    fun getUsers(): List<User>
    fun setUsers(users: List<User>)

    fun getPokemon(id: Int): Single<Pokemon?>
    fun setPokemon(pokemon: Pokemon)

    fun getPokemons(page: Int, offset: Int): List<Pokemon>?
    fun setPokemons(pokemons : List<Pokemon>)

    fun getUserPokemons(): Single<List<Pokemon>?>
    fun setUserPokemons(pokemons: List<Pokemon>)

}