package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.presenter.WelcomePresenter
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.android.synthetic.main.fragment_welcome.view.*

/**
 * Created by louis on 28/01/2018.
 */
class WelcomeFragment : Fragment() {

    companion object {
        private val KEY_FACEBOOK_ID = "key_facebook_id"
        fun newInstance(facebookId : String) : WelcomeFragment {
            val fragment = WelcomeFragment()
            val bundle = Bundle()
            bundle.putString(KEY_FACEBOOK_ID, facebookId)
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var presenter : WelcomePresenter
    private lateinit var facebookId : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val arguments = arguments

        if (arguments != null && arguments.containsKey(KEY_FACEBOOK_ID)) {
            facebookId = arguments.getString(KEY_FACEBOOK_ID)
        }

        initUI(view)
        presenter = WelcomePresenter(context, activity as SignUpNavigatorListener)

        return view
    }

    private fun initUI(view: View) {
        view.fragment_welcome_validate_button.setOnClickListener({ onClickOnValidateButton(view) })
    }

    private fun onClickOnValidateButton(view: View) {
            val pseudo = view.fragment_welcome_pseudo_edit_text.text.toString()
            presenter.signUp(User(null, facebookId, pseudo))
    }
}