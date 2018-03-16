package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * @version 1.0
 * Created by Alex on 16.03.2018.
 */


@Entity(tableName = "teams")
public class Team {

    @PrimaryKey
    @SerializedName("team_number")
    private int teamnumber;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("state_prov")
    private String state_prov;

    @SerializedName("country")
    private String country;

    @SerializedName("rookie_year")
    private int rookie_year;

    @SerializedName("motto")
    private String motto;

    public Team(int teamnumber, String nickname, String name, String city, String state_prov, String country, int rookie_year, String motto) {
        this.teamnumber = teamnumber;
        this.nickname = nickname;
        this.name = name;
        this.city = city;
        this.state_prov = state_prov;
        this.country = country;
        this.rookie_year = rookie_year;
        this.motto = motto;
    }

    public int getTeamnumber() {
        return teamnumber;
    }

    public void setTeamnumber(int teamnumber) {
        this.teamnumber = teamnumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState_prov() {
        return state_prov;
    }

    public void setState_prov(String state_prov) {
        this.state_prov = state_prov;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRookie_year() {
        return rookie_year;
    }

    public void setRookie_year(int rookie_year) {
        this.rookie_year = rookie_year;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
