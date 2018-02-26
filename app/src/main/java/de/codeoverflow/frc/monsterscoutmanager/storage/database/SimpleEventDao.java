package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;

/**
 * Created by Alex on 26.02.2018.
 */

@Dao
public interface SimpleEventDao {

    @Query("SELECT * FROM simple_events")
    List<SimpleEvent> getAll();

    @Insert
    void insertAll(SimpleEvent... events);

    @Insert
    void insert(SimpleEvent event);

    @Delete
    void delete(SimpleEvent event);


}
