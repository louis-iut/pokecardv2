package fr.iut.iem.pokecard.data.manager.impl

import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User

/**
 * Created by louis on 28/01/2018.
 */
class CacheManagerImpl : CacheManager {

    private var pokemons : Map<Int, Pokemon> = HashMap()
    private var userPokemons = listOf<Pokemon>()
    private var users = listOf<User>()
    private var currentUser : User? = null



    override fun getCurrentUser(): User? {
        return currentUser
    }

    override fun setCurrentUser(user: User) {
        currentUser = user
    }

    override fun getUsers():List<User> {
        return users
    }

    override fun setUsers(users : List<User>) {
        this.users = users
    }

    override fun getPokemon(id: Int): Pokemon? {
        return pokemons[id]
    }

    override fun setPokemon(pokemon: Pokemon) {

    }

    override fun getPokemons(page: Int, offset: Int): List<Pokemon>? {
        val min = page*offset + 1
        val max = (page+1)*offset-1

        if (max > pokemons.size-1) {
            return null
        }
        var list = listOf<Pokemon>()

        for (i in min..max) {
            if(pokemons.containsKey(i)) {
            list += pokemons[i]!!
            }
        }

        return list.sortedBy { pokemon: Pokemon -> pokemon.id }
    }

    override fun setPokemons(pokemons: List<Pokemon>) {
       // pokemons.add
        this.pokemons = pokemons.associateBy({it.id}, {it})
    }

    override fun getUserPokemons(): List<Pokemon>? {
        return userPokemons
    }

    override fun setUserPokemons(pokemons: List<Pokemon>) {
        this.userPokemons += pokemons
       // this.userPokemons = this.pokemons.distinct().sortedBy { pokemon: Pokemon -> pokemon.id }
    }
}