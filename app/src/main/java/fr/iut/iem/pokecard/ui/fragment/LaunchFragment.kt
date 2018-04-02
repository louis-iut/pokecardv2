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

class LaunchFragment : Fragment(), LaunchView {

    companion object {
        fun newInstance() : LaunchFragment {
            return LaunchFragment()
        }
    }

    private lateinit var presenter: LaunchPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflater.inflate(R.layout.fragment_launch, container, false)
        presenter = LaunchPresenter(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onLaunchError() {
        print("error on connect to api")
       // fragment_launch_spinner.visibility = GONE
       // fragment_launch_error_text.visibility = VISIBLE
        Toast.makeText(context, "NOP", Toast.LENGTH_LONG).show()
    }

    override fun onLaunchSuccess() {
        print("success")
       // fragment_launch_spinner.visibility = GONE
        (this.activity as SignUpNavigatorListener).launchSignUpFragment()
    }

}
