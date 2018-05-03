package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.TeamAtEvent;

@Dao
public interface TeamAtEventDao {

    @Query("SELECT * FROM teams_at_event")
    List<TeamAtEvent> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TeamAtEvent event);

    @Delete
    void delete(TeamAtEvent event);

}
