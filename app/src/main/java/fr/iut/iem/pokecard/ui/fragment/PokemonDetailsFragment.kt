package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.PokemonDetails
import fr.iut.iem.pokecard.ui.presenter.PokemonDetailsPresenter
import fr.iut.iem.pokecard.ui.view.PokemonDetailsView
import kotlinx.android.synthetic.main.fragment_pokedex.view.*
import kotlinx.android.synthetic.main.fragment_pokemon_details.view.*
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonDetailsFragment : Fragment(), PokemonDetailsView {
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

        presenter = PokemonDetailsPresenter(context, this.arguments!![POKEMON_ID_KEY] as Int, this)
        presenter.getPokemonDetails()

        return view
    }

    override fun updateUI(pokemon: Pokemon, pokemonDetails: PokemonDetails) {

        val view = this.view!!

        view.fragment_details_loader.visibility = View.GONE

        view.fragment_details_name.text = pokemon.name.capitalize()
        view.fragment_details_description.text = pokemonDetails.description
        Picasso.with(context).load(pokemon.image).into(view.fragment_details_image)

    }
}