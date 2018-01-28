package fr.iut.iem.pokecard.data.repository

import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Created by louis on 28/01/2018.
 */
class UserRepository(
        private val pokeAPIManager: PokeAPIManager,
        private val cacheManager: CacheManager
) {

    fun signUp(user: User): Observable<User> {
        return pokeAPIManager.signUp(user)
    }

    fun login(user: User): Observable<User> {
        return pokeAPIManager.login(user)//.onErrorResumeNext(Function { signUp(user) })
    }

    fun getUsers(): Observable<List<User>> {
        return getUsersFromCache().onErrorResumeNext(Function { getUsersFromApi() })
    }

    private fun getUsersFromCache(): Observable<List<User>> {
        var users = cacheManager.getUsers()
        if (users.isEmpty()) {
            return Observable.error(Throwable("users empty"))
        }

        return Observable.fromArray(users)
    }

    private fun getUsersFromApi(): Observable<List<User>> {
        return pokeAPIManager.getUsers()
    }
}