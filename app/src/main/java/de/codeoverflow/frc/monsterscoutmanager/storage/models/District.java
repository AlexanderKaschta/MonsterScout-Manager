package de.codeoverflow.frc.monsterscoutmanager.storage.models;

/**
 * @version 1.0
 * @author Alex
 * Created by Alex on 19.02.2018.
 */

public class District {

    private String key;
    private String shortCut;
    private int districtEnum;
    private int year;
    private String displayName;
    private int numberEvents;

    public District(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getShortCut() {
        return shortCut;
    }

    public void setShortCut(String shortCut) {
        this.shortCut = shortCut;
    }

    public int getDistrictEnum() {
        return districtEnum;
    }

    public void setDistrictEnum(int districtEnum) {
        this.districtEnum = districtEnum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getNumberEvents() {
        return numberEvents;
    }

    public void setNumberEvents(int numberEvents) {
        this.numberEvents = numberEvents;
    }
}
