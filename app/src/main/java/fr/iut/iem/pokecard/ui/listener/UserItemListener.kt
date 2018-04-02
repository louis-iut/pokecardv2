package fr.iut.iem.pokecard.ui.listener

import fr.iut.iem.pokecard.data.model.User

/**
 * Created by louis on 28/01/2018.
 */
interface UserItemListener {
    fun onClickOnUserItem()
    fun onClickOnGiftButton(user: User)
}