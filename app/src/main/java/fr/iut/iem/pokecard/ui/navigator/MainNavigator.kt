package fr.iut.iem.pokecard.ui.navigator

import android.content.Context
import android.support.v4.app.FragmentManager
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.fragment.PokedexFragment
import fr.iut.iem.pokecard.ui.fragment.UserPokedexFragment
import fr.iut.iem.pokecard.ui.fragment.UsersFragment

/**
 * Created by louis on 27/01/2018.
 */
class MainNavigator(private var context : Context, private var fragmentManager: FragmentManager) {

    private val POKEDEX_FRAGMENT = 0
    private val USER_POKEDEX_FRAGMENT = 1
    private val USERS_FRAGMENT = 2

    private var currentFragment = 0

    fun launchPokedexView() {
        fragmentManager.beginTransaction()
                .addToBackStack("pokedex")
                .replace(R.id.activity_main_frame_layout, PokedexFragment.newInstance())
                .commit()

        currentFragment = POKEDEX_FRAGMENT
    }

    fun launchUserPokedexView() {
        fragmentManager.beginTransaction()
                .addToBackStack("pokedex")
                .replace(R.id.activity_main_frame_layout, UserPokedexFragment.newInstance())
                .commit()

        currentFragment = USER_POKEDEX_FRAGMENT
    }

    fun launchUsersView() {
        fragmentManager.beginTransaction()
                .addToBackStack("user_pokedex")
                .replace(R.id.activity_main_frame_layout, UsersFragment.newInstance())
                .commit()

        currentFragment = USERS_FRAGMENT
    }
}