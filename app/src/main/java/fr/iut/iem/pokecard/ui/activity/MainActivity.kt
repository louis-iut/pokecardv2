package fr.iut.iem.pokecard.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.navigator.MainNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavigator : MainNavigator
    private var previousTabs: MutableList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainNavigator = MainNavigator(this, supportFragmentManager)
        mainNavigator.launchUserPokedexView()

        initUI()

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

    private fun initUI() {
        activity_main_tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {
                previousTabs.add(tab.position)
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
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
        })
    }

    override fun onBackPressed() {
        if (previousTabs.isEmpty()) {
            finishAffinity()
        } else {
            managePreviousTabs()
        }
    }

    private fun managePreviousTabs() {
        val index = previousTabs.size - 1
        val lastTabPosition = previousTabs[index]
        val lastTab = activity_main_tab_layout.getTabAt(lastTabPosition)
        lastTab!!.select()
        previousTabs.removeAt(index) //remove new current tab from the list
        previousTabs.removeAt(index) //remove previous tabs which was added in the list because of onTabUnselected
    }
}
