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
import fr.iut.iem.pokecard.ui.listener.PokedexItemListener
import fr.iut.iem.pokecard.ui.presenter.UserPokedexPresenter
import fr.iut.iem.pokecard.ui.view.PokedexView
import kotlinx.android.synthetic.main.fragment_user_pokemons.*
import kotlinx.android.synthetic.main.fragment_user_pokemons.view.*
import kotlinx.android.synthetic.main.poke_toolbar.*

/**
 * Created by louis on 28/01/2018.
 */
class UserPokedexFragment : Fragment(), PokedexView {

    companion object {
        fun newInstance() : UserPokedexFragment {
            return UserPokedexFragment()
        }
    }

    private lateinit var presenter : UserPokedexPresenter
    private lateinit var adapter : PokedexAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = UserPokedexPresenter(this)

        return inflater.inflate(R.layout.fragment_user_pokemons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.getCurrentUser()
    }

    override fun updateUI(pokemons: List<Pokemon>) {
        this.view!!.fragment_user_loader.visibility = View.GONE
        adapter.setPokedex(pokemons)
    }

    private fun initRecyclerView() {
        adapter = PokedexAdapter(activity as PokedexItemListener)
        fragment_user_pokemons_list.layoutManager = LinearLayoutManager(context)
        fragment_user_pokemons_list.adapter = adapter
    }

    override fun onGiftSuccess() {
    }

    override fun onGiftComplete() {
    }
}