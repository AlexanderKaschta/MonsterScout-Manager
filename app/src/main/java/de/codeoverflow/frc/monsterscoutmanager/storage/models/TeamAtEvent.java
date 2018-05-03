package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "teams_at_event", foreignKeys = {@ForeignKey(entity = Event.class, parentColumns = "event_key", childColumns = "eventKey"),
        @ForeignKey(entity = Team.class, childColumns = "teamNumber", parentColumns = "teamNumber")})
public class TeamAtEvent {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    public int id;

    @ColumnInfo(name = "teamNumber")
    public int teamNumber;

    @ColumnInfo(name = "eventKey")
    public String eventKey;

    public TeamAtEvent(int id, int teamNumber, String eventKey) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.eventKey = eventKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
