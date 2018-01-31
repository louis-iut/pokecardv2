package fr.iut.iem.pokecard.ui.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.listener.PodedexItemListener
import fr.iut.iem.pokecard.ui.listener.UserItemListener
import fr.iut.iem.pokecard.ui.navigator.MainNavigator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserItemListener, PodedexItemListener {

    private lateinit var navigator: MainNavigator
    private var previousTabs: MutableList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = MainNavigator(this, supportFragmentManager)
        navigator.launchUserPokedexView()

        initUI()
    }

    override fun onClickOnUserItem() {
        TODO("not implemented")
    }

    override fun onClickOnGiftButton() {
        navigator.launchGiftView()
    }

    override fun onClickOnPokemon() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        if (previousTabs.isEmpty()) {
            finishAffinity()
        } else {
            managePreviousTabs()
        }
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
                        navigator.launchUserPokedexView()
                    }
                    1 -> {
                        navigator.launchPokedexView()
                    }
                    2 -> {
                        navigator.launchUsersView()
                    }
                }
            }
        })
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
