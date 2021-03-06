package fr.iut.iem.pokecard.ui.presenter

import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.manager.impl.GiftParameters
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.data.repository.PokemonRepository
import fr.iut.iem.pokecard.data.repository.UserRepository
import fr.iut.iem.pokecard.ui.view.PokedexView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by QuentinGenevois on 01/04/2018.
 */
class GiftPresenter (private var pokedexView: PokedexView) {

    private var userRepository : UserRepository = PokeCardApp.application().getUserRepository()
    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()

    lateinit var currentUser: User

    fun getCurrentUser() {
        userRepository.getCurrentUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                                getUserPokemons(it.id)
                                this.currentUser = it
                        },
                        onError = { Log.e("TEST","NO", it)}
                )
    }

    fun sendGift(userId: Int, pokemonId: Int) {

        val giftParameters = GiftParameters(this.currentUser.id, userId, pokemonId)

        userRepository.sendGift(giftParameters)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            pokemonRepository.getUserPokemonsFromApi(this.currentUser.id)
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeBy(
                                            onNext = { pokedexView.onGiftSuccess() },
                                            onError = { Log.e("TEST","NO", it)},
                                            onComplete = { pokedexView.onGiftComplete() }
                                    )
                            },
                        onError = {
                            pokedexView.onGiftComplete()
                        }
                )
    }

    private fun getUserPokemons(id: Int) {
        pokemonRepository.getUserPokemons(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {pokedexView.updateUI(it)},
                        onError = { Log.e("TEST","NO", it)}
                )
    }
}