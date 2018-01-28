package fr.iut.iem.pokecard.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.ui.listener.PodedexItemListener
import kotlinx.android.synthetic.main.item_pokemon.view.*

/**
 * Created by louis on 28/01/2018.
 */
class PokedexAdapter (
        private val podedexItemListener: PodedexItemListener
) : RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>() {

    private var pokedex: List<Pokemon> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pokemon, parent, false)

        return PokemonViewHolder(view, podedexItemListener)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokedex[position])
    }

    override fun getItemCount(): Int {
        return pokedex.size
    }

    fun setPokedex(pokedex : List<Pokemon>) {
        this.pokedex +=  pokedex
        notifyDataSetChanged()
    }

    class PokemonViewHolder(
            private val view : View,
            private val podedexItemListener: PodedexItemListener

    ) : RecyclerView.ViewHolder(view) {

        fun bind(pokemon: Pokemon) {
            view.item_pokemon_name.text = pokemon.name
            Picasso.with(view.context).load(pokemon.image).into(view.item_pokemon_image)
        }
    }
}