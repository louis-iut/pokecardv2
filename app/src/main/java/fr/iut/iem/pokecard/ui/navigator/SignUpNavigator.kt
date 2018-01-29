package fr.iut.iem.pokecard.ui.navigator

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentManager
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.activity.MainActivity
import fr.iut.iem.pokecard.ui.fragment.SignUpFragment
import fr.iut.iem.pokecard.ui.fragment.UsersFragment
import fr.iut.iem.pokecard.ui.fragment.WelcomeFragment

/**
 * Created by louis on 28/01/2018.
 */
class SignUpNavigator(private val context: Context, private val fragmentManager: FragmentManager) {

    private val SIGN_UP_FRAGMENT = 0
    private val WELCOME_FRAGMENT = 1

    private var currentFragment = 0

    fun launchSignUpFragment() {
        fragmentManager.beginTransaction()
                .addToBackStack("sign_up")
                .replace(R.id.activity_sign_up_frame_layout, SignUpFragment.newInstance())
                .commit()

        currentFragment = SIGN_UP_FRAGMENT
    }

    fun launchWelcomeFragment(facebookId : String) {
        fragmentManager.beginTransaction()
                .addToBackStack("welcome")
                .replace(R.id.activity_sign_up_frame_layout, WelcomeFragment.newInstance(facebookId))
                .commit()

        currentFragment = WELCOME_FRAGMENT
    }

    fun launchMainActivity() {
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}