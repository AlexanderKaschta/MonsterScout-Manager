package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Team;

/**
 * @author Alex
 * Created by Alex on 16.03.2018.
 */
@Dao
public interface TeamDao {

    @Query("SELECT * FROM teams")
    List<Team> getAll();

    @Query("SELECT * FROM teams WHERE teamNumber=:number")
    Team findByNumber(int number);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Team... events);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Team event);

    @Delete
    void delete(Team event);


}
