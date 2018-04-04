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
import kotlinx.android.synthetic.main.fragment_users.*

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
    private lateinit var presenter: UsersPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = UsersPresenter(this)

        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.getUsers()
    }

    override fun updateUI(users: List<User>) {

        fragment_users_loader.visibility = View.GONE

        adapter.setUserList(users)
    }

    private fun initRecyclerView() {
        adapter = UserListAdapter(activity as UserItemListener)
        fragment_users_list.layoutManager = LinearLayoutManager(context)
        fragment_users_list.adapter = adapter
    }
}