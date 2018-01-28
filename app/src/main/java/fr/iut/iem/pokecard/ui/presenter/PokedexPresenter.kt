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
import io.reactivex.schedulers.Schedulers

/**
 * Created by louis on 27/01/2018.
 */
class PokedexPresenter (
        private var context: Context,
        private var pokedexView: PokedexView
) {

    private var pokemonRepository : PokemonRepository = PokeCardApp.application().getPokemonRepository()

    fun getPokemons() {
        pokemonRepository.getPokemons(1, 20).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<Pokemon>> {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onComplete() {}

                    override fun onNext(pokemons: List<Pokemon>) {
                        Log.e("TEST", pokemons.toString())
                        pokedexView.updateUI(pokemons)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TEST","NO", e)
                    }
                })
    }

}