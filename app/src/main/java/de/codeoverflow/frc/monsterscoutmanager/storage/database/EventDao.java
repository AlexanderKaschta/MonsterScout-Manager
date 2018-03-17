package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.Event;

/**
 * @author Alex
 * @version 1.0
 * Created by Alex on 16.03.2018.
 */
@Dao
public interface EventDao {

    @Query("SELECT * FROM events")
    List<Event> getAll();

    @Query("SELECT * FROM events WHERE event_key=:inputKey")
    Event findByNumber(String inputKey);

    @Insert
    void insertAll(Event... events);

    @Insert
    void insert(Event event);

    @Delete
    void delete(Event event);
}
