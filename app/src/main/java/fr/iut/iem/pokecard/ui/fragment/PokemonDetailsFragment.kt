package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
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
import kotlinx.android.synthetic.main.poke_toolbar.*
import kotlinx.android.synthetic.main.fragment_pokemon_details.*
import kotlinx.android.synthetic.main.poke_toolbar.view.*

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

        initUI(view)

        return view
    }

    private fun initUI(view: View) {
        view.poke_toolbar.title = resources.getString(R.string.fragment_pokemon_detail_toolbar_title)
    }

    override fun updateUI(pokemon: Pokemon, pokemonDetails: PokemonDetails) {
        fragment_details_loader.visibility = View.GONE

        fragment_details_name.text = pokemon.name.capitalize()
        fragment_details_description.text = pokemonDetails.description
        Picasso.with(context).load(pokemon.image).into(fragment_details_image)

        this.view!!.poke_toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
    }
}