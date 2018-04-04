package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.listener.SignUpNavigatorListener
import fr.iut.iem.pokecard.ui.presenter.LaunchPresenter
import fr.iut.iem.pokecard.ui.view.LaunchView
import kotlinx.android.synthetic.main.fragment_launch.*
import kotlinx.android.synthetic.main.fragment_launch.view.*

class LaunchFragment : Fragment(), LaunchView {

    companion object {
        fun newInstance() : LaunchFragment {
            return LaunchFragment()
        }
    }

    private lateinit var presenter: LaunchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = LaunchPresenter(this)
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fragment_launch_retry_button.setOnClickListener {
            setVisibility(GONE)
            fragment_launch_spinner.visibility = VISIBLE
            presenter.ping()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.signUp()
        presenter.ping()
    }

    override fun onLaunchError() {
        print("error on connect to api")
        setVisibility(VISIBLE)
    }

    override fun onLaunchSuccess() {
        print("success")
        setVisibility(GONE)
        (this.activity as SignUpNavigatorListener).launchSignUpFragment()
    }

    private fun setVisibility(visibility: Int) {
        fragment_launch_spinner.visibility = GONE
        fragment_launch_error_text.visibility = visibility
        fragment_launch_retry_button.visibility = visibility
    }
}
