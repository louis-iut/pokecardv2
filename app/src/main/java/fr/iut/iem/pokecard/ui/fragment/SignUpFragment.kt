package fr.iut.iem.pokecard.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.presenter.SignUpPresenter
import fr.iut.iem.pokecard.ui.view.SignUpView
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

/**
 * Created by louis on 28/01/2018.
 */
class SignUpFragment : Fragment(), SignUpView {

    companion object {
        fun newInstance() : SignUpFragment {
            return SignUpFragment()
        }
    }

    private lateinit var presenter: SignUpPresenter
    private lateinit var callbackManager: CallbackManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        presenter = SignUpPresenter(context, this, activity as SignUpNavigatorListener)
        initFacebookConnexion(view)

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    private fun initFacebookConnexion(view: View) {
        callbackManager = CallbackManager.Factory.create()
        view.fragment_sign_up_login_button.setReadPermissions("email")
        view.fragment_sign_up_login_button.fragment = this
        view.fragment_sign_up_login_button.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                presenter.login(result.accessToken.userId)
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException?) {
            }
        })
    }
}