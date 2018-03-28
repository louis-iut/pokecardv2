package fr.iut.iem.pokecard.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.ui.presenter.PokemonDetailsPresenter

class PokemonDetailsFragment : Fragment() {
    companion object {

        private const val POKEMON_ID_KEY = "pokemonID"

        fun newInstance(pokemonID: Int) : PokemonDetailsFragment {
            val args = Bundle()
            args.putInt(POKEMON_ID_KEY, pokemonID)

            val fragment = PokemonDetailsFragment()
            fragment.arguments = args

            return fragment
        }
    }

    private lateinit var presenter : PokemonDetailsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_details, container, false)

        presenter = PokemonDetailsPresenter(context, this.arguments!![POKEMON_ID_KEY] as Int)
        presenter.getPokemonDetails()

        return view
    }
}