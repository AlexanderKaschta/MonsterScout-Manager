package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.Event;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Team;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.TeamAtEvent;

/**
 * @author Alex
 * @version 1
 * Created by Alex on 26.02.2018.
 */
@Database(entities = {SimpleEvent.class, Team.class, Event.class, TeamAtEvent.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase{

    public abstract SimpleEventDao getSimpleEventDao();

    public abstract TeamDao getTeamDao();

    public abstract EventDao getEventDao();

    public abstract TeamAtEventDao getTeamAtEventDao();

}
