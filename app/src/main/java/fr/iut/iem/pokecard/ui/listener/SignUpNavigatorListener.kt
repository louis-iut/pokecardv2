package fr.iut.iem.pokecard.ui.listener

/**
 * Created by louis on 28/01/2018.
 */
interface SignUpNavigatorListener {
    fun launchSignUpFragment()
    fun launchWelcomeFragment(facebookId : String)
    fun launchMainActivity()
}