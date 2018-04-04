package fr.iut.iem.pokecard.data.manager.impl

import com.raizlabs.android.dbflow.kotlinextensions.insert
import com.raizlabs.android.dbflow.kotlinextensions.select
import fr.iut.iem.pokecard.data.manager.`interface`.DBManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User

class DBManagerImpl: DBManager {
    override fun getCurrentUser(): User? {
        val user = select.from(User::class.java).limit(1).querySingle()
        return user
    }

    override fun setCurrentUser(user: User) {
        user.insert()
    }

    override fun getUsers(): List<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUsers(users: List<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPokemon(id: Int): Pokemon? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPokemon(pokemon: Pokemon) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPokemons(page: Int, offset: Int): List<Pokemon>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPokemons(pokemons: List<Pokemon>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserPokemons(): List<Pokemon>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUserPokemons(pokemons: List<Pokemon>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}