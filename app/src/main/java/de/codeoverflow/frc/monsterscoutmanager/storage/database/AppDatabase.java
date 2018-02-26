package de.codeoverflow.frc.monsterscoutmanager.storage.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;

/**
 * @author Alex
 * @version 1
 * Created by Alex on 26.02.2018.
 */
@Database(entities = {SimpleEvent.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract SimpleEventDao getSimpleEventDao();

}
