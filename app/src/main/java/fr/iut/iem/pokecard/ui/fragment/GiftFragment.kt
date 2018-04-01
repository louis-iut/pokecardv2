package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.User
import kotlinx.android.synthetic.main.fragment_gift.view.*

/**
 * Created by louis on 31/01/2018.
 */
class GiftFragment : Fragment() {

    companion object {

        private const val USER_NAME_KEY = "pseudo"
        private const val USER_ID_KEY = "id"

        fun newInstance(user: User) : GiftFragment {
            val args = Bundle()
            args.putString(GiftFragment.USER_NAME_KEY, user.pseudo)
            args.putInt(GiftFragment.USER_ID_KEY, user.id!!)

            val fragment = GiftFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gift, container, false)

        initUI(view)

        return view
    }

    private fun initUI(view: View) {
        val userName = this.arguments!![USER_NAME_KEY] as String
        view.fragment_gift_informations_text.text = "Quel Pokemon voulez-vous envoyer à " + userName + " ?"
    }
}