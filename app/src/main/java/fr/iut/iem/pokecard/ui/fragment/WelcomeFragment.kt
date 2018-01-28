package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.presenter.SignUpPresenter

/**
 * Created by louis on 28/01/2018.
 */
class WelcomeFragment : Fragment() {

    companion object {
        fun newInstance() : WelcomeFragment {
            return WelcomeFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        //presenter = SignUpPresenter(context, this)
        //initFacebookConnexion(view)

        return view
    }
}