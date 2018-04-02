package fr.iut.iem.pokecard.ui.presenter

import fr.iut.iem.pokecard.PokeCardApp
import fr.iut.iem.pokecard.ui.view.LaunchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class LaunchPresenter(private var view: LaunchView) {

    private var utilsRepository = PokeCardApp.application().getUtilsRepository()

    init {
        ping()
    }

    private fun ping() {
        utilsRepository.ping()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { view.onLaunchSuccess() },
                        onError = { view.onLaunchError() }
                )
    }
}