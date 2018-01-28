package fr.iut.iem.pokecard.ui.presenter

import android.content.Context
import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.repository.PokemonRepository
import fr.iut.iem.pokecard.ui.view.PokedexView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by louis on 27/01/2018.
 */
class PokedexPresenter (
        private var context: Context,
        private var pokedexView: PokedexView
) {

    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()

    fun getPokemons(page : Int, offset : Int) {
        pokemonRepository.getPokemons(page, offset).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {pokedexView.updateUI(it)},
                        onError = {Log.e("TEST","NO", it)}
                )
    }

}