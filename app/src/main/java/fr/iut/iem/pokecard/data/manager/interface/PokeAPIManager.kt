package fr.iut.iem.pokecard.data.manager.`interface`

import fr.iut.iem.pokecard.data.manager.impl.GiftParameters
import fr.iut.iem.pokecard.data.model.Message
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.PokemonDetails
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable

/**
 * Created by louis on 27/01/2018.
 */
interface PokeAPIManager {

    fun ping(): Observable<Message>
    fun getUsers(): Observable<List<User>>
    fun getPokemonDetailsByID(id: Int): Observable<PokemonDetails>
    fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>>
    fun login(user: User): Observable<User>
    fun signUp(user: User): Observable<User>
    fun getUserPokemons(id: Int): Observable<List<Pokemon>>
    fun sendGift(giftParameters: GiftParameters): Observable<Message>
}