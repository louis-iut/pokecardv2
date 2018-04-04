package fr.iut.iem.pokecard.data.manager

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = PokeDB.DB_NAME, version = PokeDB.VERSION)
class PokeDB {
    companion object {
        const val DB_NAME = "Comics"
        const val VERSION = 1
    }
}