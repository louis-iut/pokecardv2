package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.ui.adapter.PokedexAdapter
import fr.iut.iem.pokecard.ui.listener.PodedexItemListener
import fr.iut.iem.pokecard.ui.presenter.UserPokedexPresenter
import fr.iut.iem.pokecard.ui.view.PokedexView
import kotlinx.android.synthetic.main.fragment_user_pokemons.view.*

/**
 * Created by louis on 28/01/2018.
 */
class UserPokedexFragment : Fragment(), PokedexView, PodedexItemListener {

    companion object {
        fun newInstance() : UserPokedexFragment {
            return UserPokedexFragment()
        }
    }

    private lateinit var presenter : UserPokedexPresenter
    private lateinit var adapter : PokedexAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user_pokemons, container, false)

        initRecyclerView(view)
        presenter = UserPokedexPresenter(this)
        presenter.getCurrentUser()

        return view
    }

    override fun updateUI(pokemons: List<Pokemon>) {
        adapter.setPokedex(pokemons)
    }

    override fun onClickOnPokemon() {

    }

    private fun initRecyclerView(view : View) {
        var adapter = PokedexAdapter(this)
        view.fragment_user_pokedex_recycler_view.layoutManager = LinearLayoutManager(context)
        view.fragment_user_pokedex_recycler_view.adapter = adapter
    }
}