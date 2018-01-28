package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.ui.adapter.PokedexAdapter
import fr.iut.iem.pokecard.ui.listener.PodedexItemListener
import fr.iut.iem.pokecard.ui.presenter.PokedexPresenter
import fr.iut.iem.pokecard.ui.view.PokedexView
import kotlinx.android.synthetic.main.fragment_user_pokemons.view.*

/**
 * Created by louis on 27/01/2018.
 */
class PokedexFragment : Fragment(), PokedexView, PodedexItemListener {
    override fun onClickOnPokemon() {
    }

    private lateinit var presenter : PokedexPresenter
    private lateinit var adapter : PokedexAdapter

    companion object {
        fun newInstance() : PokedexFragment {
            return PokedexFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_pokedex, container, false)

        initRecyclerView(view)
        presenter = PokedexPresenter(context, this)
        presenter.getPokemons()

        return view
    }

    override fun updateUI(pokemons: List<Pokemon>) {
        adapter.setPokedex(pokemons)
    }

    private fun initRecyclerView(view : View) {
        adapter = PokedexAdapter(this)
        view.recycler_view.layoutManager = LinearLayoutManager(context)
        view.recycler_view.adapter = adapter
    }
}