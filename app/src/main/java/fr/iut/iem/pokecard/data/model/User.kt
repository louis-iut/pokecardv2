package fr.iut.iem.pokecard.data.model

import com.google.gson.annotations.SerializedName
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import fr.iut.iem.pokecard.data.manager.PokeDB

/**
 * Created by louis on 28/01/2018.
 */
@Table(database = PokeDB::class)
data class User(
        @PrimaryKey
        @field:SerializedName("id") val id: Int?,
        @Column
        @field:SerializedName("facebook_id") val facebookId: String,
        @Column
        @field:SerializedName("pseudo") val pseudo: String?)