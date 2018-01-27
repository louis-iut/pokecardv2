package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R

/**
 * Created by louis on 27/01/2018.
 */
class PokedexFragment : Fragment() {

    companion object {
        fun newInstance() : PokedexFragment {
            return PokedexFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokedex, container, false)

        return view
    }
}