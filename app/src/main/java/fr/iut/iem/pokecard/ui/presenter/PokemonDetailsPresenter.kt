package fr.iut.iem.pokecard.ui.presenter

import android.content.Context
import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.Consts
import fr.iut.iem.pokecard.data.repository.PokemonRepository
import fr.iut.iem.pokecard.ui.view.PokemonDetailsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


/**
 * Created by QuentinGenevois on 27/03/2018.
 */
class PokemonDetailsPresenter (
        private var context: Context?,
        private var pokemonID: Int,
        private var pokemonDetailsView: PokemonDetailsView
){
    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()

    fun getPokemonDetails() {
        pokemonRepository.getPokemonDetailsByID(pokemonID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            pokemonDetailsView.updateUI(it)
                        },
                        onError = {Log.e("TEST","NO", it)}
                )
    }
}