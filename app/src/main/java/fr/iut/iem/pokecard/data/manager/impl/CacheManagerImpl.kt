package fr.iut.iem.pokecard.data.manager.impl

import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable

/**
 * Created by louis on 28/01/2018.
 */
class CacheManagerImpl : CacheManager {

    private var pokemons = listOf<Pokemon>()
    private var users = listOf<User>()

    override fun getUsers():List<User> {
        return users
    }

    override fun setUsers(users : List<User>) {
        this.users = users
    }

    override fun getPokemonByID(id: Int): Pokemon? {
        return null
    }

    override fun setPokemon(pokemon: Pokemon) {

    }

    override fun getPokemons(page: Int, offset: Int): List<Pokemon>? {
        val min = page*offset
        val max = (page+1)*offset-1

        if (max > pokemons.size-1) {
            return null
        }

        return pokemons.subList(min, max)
    }

    override fun setPokemons(pokemons: List<Pokemon>) {
        this.pokemons += pokemons
        this.pokemons = this.pokemons.distinct().sortedBy { pokemon: Pokemon -> pokemon.id }
    }
}