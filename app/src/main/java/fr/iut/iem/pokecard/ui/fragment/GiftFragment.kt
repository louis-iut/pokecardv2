package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R

/**
 * Created by louis on 31/01/2018.
 */
class GiftFragment : Fragment() {

    companion object {
        fun newInstance() : UsersFragment {
            return UsersFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gift, container, false)

        /*initRecyclerView(view)

        var presenter = UsersPresenter(this)
        presenter.getUsers()*/

        return view
    }
}