package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R

/**
 * Created by louis on 28/01/2018.
 */
class UserPokedexFragment : Fragment() {

    companion object {
        fun newInstance() : UserPokedexFragment {
            return UserPokedexFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user_pokemons, container, false)

        return view
    }
}