package fr.iut.iem.pokecard.ui.presenter

import android.util.Log
import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.data.repository.UserRepository
import fr.iut.iem.pokecard.ui.view.UsersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by louis on 28/01/2018.
 */
class UsersPresenter(private val usersView: UsersView) {

    private val userRepository: UserRepository = PokeCardApp.application().getUserRepository()

    fun getUsers() {
        userRepository.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {usersView.updateUI(it)},
                        onError = { Log.e("TEST","NO", it)}
                )
    }

}