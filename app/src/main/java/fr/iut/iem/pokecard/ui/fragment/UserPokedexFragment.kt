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
import kotlinx.android.synthetic.main.fragment_user_pokemons.*
import kotlinx.android.synthetic.main.fragment_user_pokemons.view.*

/**
 * Created by louis on 28/01/2018.
 */
class UserPokedexFragment : Fragment(), PodedexItemListener {

    companion object {
        fun newInstance() : UserPokedexFragment {
            return UserPokedexFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user_pokemons, container, false)

        initRecyclerView(view)

        return view
    }

    override fun onClickOnPokemon() {

    }

    private fun initRecyclerView(view : View) {
        var adapter = PokedexAdapter(this)
        view.recycler_view.layoutManager = LinearLayoutManager(context)
        view.recycler_view.adapter = adapter
        var pokemon = Pokemon(1, "", "COUCOU")
        var pokemon2 = Pokemon(1, "", "COUCOU")
        var pokemon3 = Pokemon(1, "", "COUCOU")
        var pokemon4 = Pokemon(1, "", "COUCOU")
        adapter.setPokedex(listOf(pokemon, pokemon2, pokemon3, pokemon4))

    }
}