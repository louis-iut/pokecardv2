package fr.iut.iem.pokecard.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.ui.listener.UserItemListener
import kotlinx.android.synthetic.main.item_pokemon.view.*
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by louis on 28/01/2018.
 */
class UserListAdapter(private val userItemListener: UserItemListener) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var userList: List<User> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)

        return UserViewHolder(view, userItemListener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserList(userList : List<User>) {
        this.userList =  userList
        notifyDataSetChanged()
    }

    class UserViewHolder(
            private val view : View,
            private val userItemListener: UserItemListener
    ) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            view.item_user_pseudo.text = user.pseudo
            view.setOnClickListener { userItemListener.onClickOnUserItem() }
            view.item_user_gift_button.setOnClickListener { userItemListener.onClickOnUserItem() }
        }
    }
}