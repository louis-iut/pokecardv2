package fr.iut.iem.pokecard.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.iut.iem.pokecard.R
import fr.iut.iem.pokecard.data.model.User
import fr.iut.iem.pokecard.ui.adapter.UserListAdapter
import fr.iut.iem.pokecard.ui.listener.UserItemListener
import fr.iut.iem.pokecard.ui.presenter.UsersPresenter
import fr.iut.iem.pokecard.ui.view.UsersView
import kotlinx.android.synthetic.main.misc_users.view.*

/**
 * Created by louis on 28/01/2018.
 */
class UsersFragment : Fragment(), UsersView {

    companion object {
        fun newInstance() : UsersFragment {
            return UsersFragment()
        }
    }

    private lateinit var adapter : UserListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_users, container, false)

        initRecyclerView(view)

        var presenter = UsersPresenter(this)
        presenter.getUsers()

        return view
    }

    override fun updateUI(users: List<User>) {
        adapter.setUserList(users)
    }

    private fun initRecyclerView(view: View) {
        adapter = UserListAdapter(activity as UserItemListener)
        view.misc_users_recycler_view.layoutManager = LinearLayoutManager(context)
        view.misc_users_recycler_view.adapter = adapter
    }
}