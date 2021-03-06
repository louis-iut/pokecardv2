package fr.iut.iem.pokecard.ui.presenter

import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.repository.PokemonRepository
import fr.iut.iem.pokecard.data.repository.UserRepository
import fr.iut.iem.pokecard.ui.view.PokedexView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by louis on 29/01/2018.
 */
class UserPokedexPresenter(private var pokedexView: PokedexView) {

    private var userRepository : UserRepository = PokeCardApp.application().getUserRepository()
    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()

    fun getCurrentUser() {
        userRepository.getCurrentUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onNext = {
                            getUserPokemons(it.id)
                        },
                        onError = { Log.e("TEST","NO", it)}
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