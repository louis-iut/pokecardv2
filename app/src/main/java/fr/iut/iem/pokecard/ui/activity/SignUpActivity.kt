package fr.iut.iem.pokecard.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.navigator.SignUpNavigator

class SignUpActivity : AppCompatActivity(), SignUpNavigatorListener {

    private lateinit var navigator: SignUpNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        navigator = SignUpNavigator(this, supportFragmentManager)
        navigator.launchSignUpFragment()
    }

    override fun launchWelcomeFragment() {
        navigator.launchWelcomeFragment()
    }
}
