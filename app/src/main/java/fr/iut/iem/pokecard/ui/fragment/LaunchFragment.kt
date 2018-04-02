package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.presenter.LaunchPresenter
import fr.iut.iem.pokecard.ui.view.LaunchView

class LaunchFragment : Fragment(), LaunchView {

    private lateinit var presenter: LaunchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflater.inflate(R.layout.fragment_launch, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = LaunchPresenter(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onLaunchError() {
        Toast.makeText(context, "NOP", Toast.LENGTH_LONG)
    }

    override fun onLaunchSucces() {
        (this.activity as SignUpNavigatorListener).launchSignUpFragment()
    }

}
