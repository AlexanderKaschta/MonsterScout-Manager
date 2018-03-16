package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import de.codeoverflow.frc.monsterscoutmanager.storage.database.convertor.DateConvertor;

/**
 * @author Alex
 * Created by Alex on 16.03.2018.
 */

@Entity
public class Event {

    @PrimaryKey
    @NonNull
    private String key;

    @ColumnInfo(name = "event_code")
    private String eventCode;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "year")
    private int year;

    @ColumnInfo(name = "timezone")
    private String timezone;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "start_date")
    @TypeConverters({DateConvertor.class})
    private Date startDate;

    @ColumnInfo(name = "isFinished")
    private boolean isFinished;

    public Event(@NonNull String key, String eventCode, String name, int year, String timezone, String city, String country, Date startDate, boolean isFinished) {
        this.key = key;
        this.eventCode = eventCode;
        this.name = name;
        this.year = year;
        this.timezone = timezone;
        this.city = city;
        this.country = country;
        this.startDate = startDate;
        this.isFinished = isFinished;
    }

    @NonNull
    public String getKey() {
        return key;
    }

    public void setKey(@NonNull String key) {
        this.key = key;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
