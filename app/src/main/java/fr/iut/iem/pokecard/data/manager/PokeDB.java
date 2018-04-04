package fr.iut.iem.pokecard.data.manager;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = PokeDB.DB_NAME, version = PokeDB.VERSION)
public class PokeDB {
    public static final String DB_NAME = "Poke";
    public static final int VERSION = 1;
}
