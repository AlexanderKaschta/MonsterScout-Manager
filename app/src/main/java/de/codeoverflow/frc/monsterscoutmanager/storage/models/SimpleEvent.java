package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author Alex
 * @version 1.0
 * Created by Alex on 17.02.2018.
 */

public class SimpleEvent {

    @SerializedName("key")
    private String key;
    @SerializedName("event_code")
    private String eventCode;
    @SerializedName("name")
    private String name;
    @SerializedName("year")
    private int year;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("start_date")
    private Date startDate;

    public SimpleEvent(String key, String eventCode, String name, int year, String timezone, String city, String country, Date startDate) {
        this.key = key;
        this.eventCode = eventCode;
        this.name = name;
        this.year = year;
        this.timezone = timezone;
        this.city = city;
        this.country = country;
        this.startDate = startDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
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
}
