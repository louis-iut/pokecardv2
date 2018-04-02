package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.ui.adapter.PokedexAdapter
import fr.iut.iem.pokecard.ui.listener.MainNavigatorListener
import fr.iut.iem.pokecard.ui.listener.PokedexItemListener
import fr.iut.iem.pokecard.ui.presenter.GiftPresenter
import fr.iut.iem.pokecard.ui.view.PokedexView
import kotlinx.android.synthetic.main.fragment_gift.view.*
import kotlinx.android.synthetic.main.poke_toolbar.*

/**
 * Created by louis on 31/01/2018.
 */
class GiftFragment : Fragment(), PokedexItemListener, PokedexView {

    companion object {

        private const val USER_NAME_KEY = "pseudo"
        private const val USER_ID_KEY = "id"

        fun newInstance(user: User) : GiftFragment {
            val args = Bundle()
            args.putString(GiftFragment.USER_NAME_KEY, user.pseudo)
            args.putInt(GiftFragment.USER_ID_KEY, user.id!!)

            val fragment = GiftFragment()
            fragment.arguments = args

            return fragment
        }
    }

    private lateinit var presenter : GiftPresenter
    private lateinit var adapter : PokedexAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gift, container, false)

        initUI(view)

        initRecyclerView(view)

        presenter = GiftPresenter(this)
        presenter.getCurrentUser()

        return view
    }

    override fun updateUI(pokemons: List<Pokemon>) {
        this.view!!.fragment_gift_loader.visibility = View.GONE
        poke_toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
        adapter.setPokedex(pokemons)
    }

    override fun onGiftSucceed() {
        this.view!!.fragment_gift_loader.visibility = View.GONE
        Toast.makeText(context, "Votre Pokémon a bien été envoyé !", Toast.LENGTH_SHORT).show()
        (this.activity as MainNavigatorListener).launchUserPokedexView()
    }

    private fun initRecyclerView(view : View) {
        adapter = PokedexAdapter(this)
        view.fragment_gift_list.layoutManager = LinearLayoutManager(context)
        view.fragment_gift_list.adapter = adapter
    }

    private fun initUI(view: View) {
        val userName = this.arguments!![USER_NAME_KEY] as String
        view.fragment_gift_informations_text.text = "Quel Pokemon voulez-vous envoyer à " + userName + " ?"
    }

    override fun onClickOnPokemon(id: Int) {
        this.view!!.fragment_gift_loader.visibility = View.VISIBLE
        presenter.sendGift(this.arguments!![USER_ID_KEY] as Int, id)
    }

}