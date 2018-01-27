package fr.iut.iem.pokecard

import android.app.Application
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPI
import fr.iut.iem.pokecard.data.manager.impl.PokeAPIImpl
import fr.iut.iem.pokecard.data.repository.PokemonRepository

/**
 * Created by louis on 27/01/2018.
 */
class PokeCardApp : Application() {

    companion object {
        private lateinit var application: PokeCardApp

        fun application() : PokeCardApp {
            return application
        }
    }

    private lateinit var pokeAPI: PokeAPI
    private lateinit var pokemonRepository: PokemonRepository


    override fun onCreate() {
        super.onCreate()

        application = this

        initManagers()
        initRepositories()
    }

    private fun initManagers() {
        pokeAPI = PokeAPIImpl()
    }

    private fun initRepositories() {
        pokemonRepository = PokemonRepository(pokeAPI)
    }

    fun getPokemonRepository() : PokemonRepository {
        return pokemonRepository
    }
}