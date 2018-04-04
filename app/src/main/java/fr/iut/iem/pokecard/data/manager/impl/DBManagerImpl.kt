package fr.iut.iem.pokecard.data.manager.impl

import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.kotlinextensions.save
import com.raizlabs.android.dbflow.kotlinextensions.select
import fr.iut.iem.pokecard.data.manager.PokeDB
import fr.iut.iem.pokecard.data.manager.`interface`.DBManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User

class DBManagerImpl : DBManager {

    override fun getCurrentUser(): User? {
        return select.from(User::class.java).limit(1).querySingle()
    }

    override fun setCurrentUser(user: User) {
        FlowManager.getDatabase(PokeDB.DB_NAME).executeTransaction {
            user.save()
        }
    }

    override fun getUserPokemons(): List<Pokemon>? {
        return select.from(Pokemon::class.java).queryList()
    }

    override fun setUserPokemons(pokemons: List<Pokemon>) {
        FlowManager.getDatabase(PokeDB.DB_NAME).executeTransaction {
            for (pokemon in pokemons) {
                pokemon.save()
            }
        }
    }
}