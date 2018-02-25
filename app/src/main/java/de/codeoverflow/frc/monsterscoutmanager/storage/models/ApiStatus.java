package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Alex
 * @version 1.0
 * Created by Alex on 19.02.2018.
 */

public class ApiStatus {

    @SerializedName("current_season")
    private int currentSeason;
    @SerializedName("max_season")
    private int maxSeason;
    @SerializedName("is_datafeed_down")
    private boolean isDataFeedDown;


    public ApiStatus(int currentSeason, int maxSeason, boolean isDataFeedDown) {
        this.currentSeason = currentSeason;
        this.maxSeason = maxSeason;
        this.isDataFeedDown = isDataFeedDown;
    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(int currentSeason) {
        this.currentSeason = currentSeason;
    }

    public int getMaxSeason() {
        return maxSeason;
    }

    public void setMaxSeason(int maxSeason) {
        this.maxSeason = maxSeason;
    }

    public boolean isDataFeedDown() {
        return isDataFeedDown;
    }

    public void setDataFeedDown(boolean dataFeedDown) {
        isDataFeedDown = dataFeedDown;
    }
}
