package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User

interface DBManager {

    fun getCurrentUser(): User?
    fun setCurrentUser(user: User)

    fun getPokemons(): List<Pokemon>?
    fun setPokemons(pokemons: List<Pokemon>)

    fun getUserPokemons(): List<Pokemon>?
    fun setUserPokemons(pokemons: List<Pokemon>)
}