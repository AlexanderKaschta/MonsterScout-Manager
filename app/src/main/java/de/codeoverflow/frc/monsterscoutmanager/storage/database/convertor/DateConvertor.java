package de.codeoverflow.frc.monsterscoutmanager.storage.database.convertor;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Alex on 26.02.2018.
 */

public class DateConvertor {

    @TypeConverter
    public Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }

}
