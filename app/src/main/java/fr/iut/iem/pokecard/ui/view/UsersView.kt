package fr.iut.iem.pokecard.ui.view

import fr.iut.iem.pokecard.data.model.User

/**
 * Created by louis on 28/01/2018.
 */
interface UsersView {
    fun updateUI(users : List<User>)
}