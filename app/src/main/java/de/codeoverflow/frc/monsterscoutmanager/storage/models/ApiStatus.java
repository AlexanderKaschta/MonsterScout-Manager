package de.codeoverflow.frc.monsterscoutmanager.storage.models;

/**
 * @author Alex
 * @version 1.0
 * Created by Alex on 19.02.2018.
 */

public class ApiStatus {

    private int currentSeason;
    private int maxSeason;
    private boolean isDataFeedDown;

    /**
     * Constructor
     */
    public ApiStatus(){

    }

    public int getCurrentSeason() {
        return currentSeason;
    }

    public int getMaxSeason() {
        return maxSeason;
    }

    public boolean isDataFeedDown() {
        return isDataFeedDown;
    }

    public void setCurrentSeason(int currentSeason) {
        this.currentSeason = currentSeason;
    }

    public void setMaxSeason(int maxSeason) {
        this.maxSeason = maxSeason;
    }

    public void setDataFeedDown(boolean dataFeedDown) {
        isDataFeedDown = dataFeedDown;
    }
}
