package fr.iut.iem.pokecard.ui.presenter

import android.content.Context
import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.data.repository.UserRepository
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.view.SignUpView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by louis on 28/01/2018.
 */
class SignUpPresenter(
        private val context: Context?,
        private val signUpView: SignUpView,
        private val signUpNavigatorListener: SignUpNavigatorListener
) {
    private var userRepository : UserRepository = PokeCardApp.application().getUserRepository()

    fun login(facebookId : String) {
        userRepository.login(User(0, facebookId, null))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { signUpNavigatorListener.launchMainActivity() },
                        onError = {
                            Log.e("ERREUR CO", " ! ", it)
                            signUpNavigatorListener.launchWelcomeFragment(facebookId)
                        }
                )
    }
}