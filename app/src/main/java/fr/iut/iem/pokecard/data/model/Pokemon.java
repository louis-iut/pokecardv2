package fr.iut.iem.pokecard.data.model;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import fr.iut.iem.pokecard.data.manager.PokeDB;

@Table(database = PokeDB.class)
public class Pokemon {
    @PrimaryKey
    @SerializedName("id") int id;
    @Column
    @SerializedName("imageURL") String image;
    @Column
    @SerializedName("name") String name;

    public Pokemon() {
    }

    public Pokemon(int id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
