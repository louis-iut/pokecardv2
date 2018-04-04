package fr.iut.iem.pokecard.data.repository

import fr.iut.iem.pokecard.data.manager.`interface`.CacheManager
import fr.iut.iem.pokecard.data.manager.`interface`.DBManager
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.manager.impl.GiftParameters
import fr.iut.iem.pokecard.data.model.Message
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Function

/**
 * Created by louis on 28/01/2018.
 */
class UserRepository(
        private val pokeAPIManager: PokeAPIManager,
        private val cacheManager: CacheManager,
        private val dbManager: DBManager
) {

    fun sendGift(giftParameters: GiftParameters): Observable<Message> {
        return pokeAPIManager.sendGift(giftParameters)
    }

    fun signUp(user: User): Observable<User> {
        return pokeAPIManager.signUp(user).doOnNext({
            setCurrentUserOnDB(it)
            setCurrentUserOnCache(it)
        })
    }

    fun login(user: User): Observable<User> {
        return pokeAPIManager.login(user).doOnNext({
            setCurrentUserOnDB(it)
            setCurrentUserOnCache(it)
        })
    }

    fun getUsers(): Observable<List<User>> {
        return getUsersFromCache().onErrorResumeNext(Function { getUsersFromApi() })
    }

    fun getCurrentUser(): Observable<User> {
        return getCurrentUserFromCache().onErrorResumeNext(Function { getCurrentUserFromDB() })
    }

    private fun getCurrentUserFromCache(): Observable<User> {
        var currentUser: User? = cacheManager.getCurrentUser() ?:
        return Observable.error(Throwable("no current user"))

        return Observable.just(currentUser)
    }

    private fun getCurrentUserFromDB(): Observable<User> {
        val user = dbManager.getCurrentUser()

        return Observable.just(user)
    }

    private fun setCurrentUserOnDB(user: User) {
        dbManager.setCurrentUser(user)
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

    private fun setCurrentUserOnCache(user: User) {
        cacheManager.setCurrentUser(user)
    }
}