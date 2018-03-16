package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Team;

/**
 * @author Alex
 * Created by Alex on 16.03.2018.
 */

public interface TeamDao {

    @Query("SELECT * FROM teams")
    List<Team> getAll();

    @Insert
    void insertAll(SimpleEvent... events);

    @Insert
    void insert(SimpleEvent event);

    @Delete
    void delete(SimpleEvent event);


}
