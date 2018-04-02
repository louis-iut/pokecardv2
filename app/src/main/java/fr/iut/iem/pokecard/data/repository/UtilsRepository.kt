package fr.iut.iem.pokecard.data.repository

import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.model.Message
import io.reactivex.Observable

class UtilsRepository(private val pokeAPIManager: PokeAPIManager) {

    fun ping(): Observable<Message> {
        return pokeAPIManager.ping()
    }
}