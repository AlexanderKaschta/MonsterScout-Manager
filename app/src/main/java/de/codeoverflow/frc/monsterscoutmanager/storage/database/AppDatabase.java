package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.Event;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Team;

/**
 * @author Alex
 * @version 1
 * Created by Alex on 26.02.2018.
 */
@Database(entities = {SimpleEvent.class, Team.class, Event.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase{

    public abstract SimpleEventDao getSimpleEventDao();

    public abstract TeamDao getTeamDao();

    public abstract EventDao getEventDao();

}
