package fr.iut.iem.pokecard.data.model;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import fr.iut.iem.pokecard.data.manager.PokeDB;

@Table(database = PokeDB.class)
public class User {

    @PrimaryKey
    @SerializedName("id") int id;
    @Column
    @SerializedName("facebook_id")
    String facebookId;
    @Column
    @SerializedName("pseudo") String pseudo;

    public User() {
    }

    public User(int id, String facebookId, String pseudo) {
        this.id = id;
        this.facebookId = facebookId;
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
