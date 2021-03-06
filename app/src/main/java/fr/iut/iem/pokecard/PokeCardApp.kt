package fr.iut.iem.pokecard

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowManager
import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.manager.`interface`.DBManager
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.manager.impl.CacheManagerImpl
import fr.iut.iem.pokecard.data.manager.impl.DBManagerImpl
import fr.iut.iem.pokecard.data.manager.impl.PokeAPIManagerImpl
import fr.iut.iem.pokecard.data.repository.PokemonRepository
import fr.iut.iem.pokecard.data.repository.UserRepository
import fr.iut.iem.pokecard.data.repository.UtilsRepository

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

    private lateinit var pokeAPIManager: PokeAPIManager
    private lateinit var cacheManager: CacheManager
    private lateinit var dbManager: DBManager

    private lateinit var pokemonRepository: PokemonRepository
    private lateinit var userRepository: UserRepository
    private lateinit var utilsRepository: UtilsRepository


    override fun onCreate() {
        super.onCreate()

        application = this
        FlowManager.init(this)

        initManagers()
        initRepositories()
    }

    private fun initManagers() {
        pokeAPIManager = PokeAPIManagerImpl()
        cacheManager = CacheManagerImpl()
        dbManager = DBManagerImpl()
    }

    private fun initRepositories() {
        pokemonRepository = PokemonRepository(pokeAPIManager, cacheManager, dbManager)
        userRepository = UserRepository(pokeAPIManager, cacheManager, dbManager)
        utilsRepository = UtilsRepository(pokeAPIManager)
    }

    fun getPokemonRepository() : PokemonRepository {
        return pokemonRepository
    }

    fun getUserRepository() : UserRepository {
        return userRepository
    }

    fun getUtilsRepository(): UtilsRepository {
        return utilsRepository
    }
}