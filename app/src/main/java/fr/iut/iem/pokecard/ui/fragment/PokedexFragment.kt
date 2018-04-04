package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.ui.adapter.PokedexAdapter
import fr.iut.iem.pokecard.ui.listener.MainNavigatorListener
import fr.iut.iem.pokecard.ui.listener.PokedexItemListener
import fr.iut.iem.pokecard.ui.presenter.PokedexPresenter
import fr.iut.iem.pokecard.ui.view.PokedexView
import kotlinx.android.synthetic.main.fragment_pokedex.*
import kotlinx.android.synthetic.main.fragment_pokedex.view.*
import kotlinx.android.synthetic.main.poke_toolbar.view.*

/**
 * Created by louis on 27/01/2018.
 */
class PokedexFragment : Fragment(), PokedexView, PokedexItemListener {

    companion object {
        fun newInstance() : PokedexFragment {
            return PokedexFragment()
        }
    }

    private lateinit var presenter : PokedexPresenter
    private lateinit var adapter : PokedexAdapter
    private var pokedex = listOf<Pokemon>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = PokedexPresenter(context, this)

        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.getPokemons()
    }

    override fun updateUI(pokemons: List<Pokemon>) {
        this.view!!.fragment_pokedex_loader.visibility = View.GONE
        adapter.setPokedex(pokemons)
    }

    private fun initRecyclerView() {
        adapter = PokedexAdapter(this)
        fragment_pokedex_list.layoutManager = LinearLayoutManager(context)
        fragment_pokedex_list.adapter = adapter
        fragment_pokedex_load_more_button.setOnClickListener({ getPokemons() })
    }

    private fun getPokemons() {
        this.view!!.fragment_pokedex_loader.visibility = View.VISIBLE
        presenter.getPokemons()
    }

    override fun onClickOnPokemon(id : Int) {
        (this.activity as MainNavigatorListener).launchPokemonDetails(id)
    }

    override fun onGiftSuccess() {
    }

    override fun onGiftComplete() {
    }
}