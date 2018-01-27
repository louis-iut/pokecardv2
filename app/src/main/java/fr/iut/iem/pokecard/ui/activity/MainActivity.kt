package fr.iut.iem.pokecard.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.ui.navigator.MainNavigator
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavigator : MainNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainNavigator = MainNavigator(this, supportFragmentManager)
        mainNavigator.launchUserPokedexView()

        activity_main_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                this@MainActivity.onTabSelected(tab)
            }

        })

        /*var pokemonRepository = PokeCardApp.application().getPokemonRepository()
        pokemonRepository.getPokemonByID(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Pokemon> {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onNext(pokemon: Pokemon) {
                        Log.e("TEST", pokemon.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TEST", "NO", e)
                    }

                    override fun onComplete() {}
                })*/
    }

    private fun onTabSelected(tab: TabLayout.Tab) {
        when (tab.position) {
            0 -> {
                mainNavigator.launchUserPokedexView()
            }
            1 -> {
                mainNavigator.launchPokedexView()
            }
            2 -> {
                mainNavigator.launchUsersView()
            }
        }
    }

    /*private fun onTabUnselected(tab: TabLayout.Tab) {
        when (tab.position) {
            0 -> {
                previousTabs.add(0)
                tab.setIcon(R.drawable.ic_home_off)
                tab.text = ""
            }
            1 -> {
                previousTabs.add(1)
                tab.setIcon(R.drawable.ic_search_off)
                tab.text = ""
            }
            2 -> {
                previousTabs.add(2)
                tab.setIcon(R.drawable.ic_message_off)
                tab.text = ""
            }
            3 -> {
                previousTabs.add(3)
                tab.setIcon(R.drawable.ic_profile_off)
                tab.text = ""
            }
            else -> {
            }
        }
        Log.i(TAG, "before: " + previousTabs)
    }*/
}
