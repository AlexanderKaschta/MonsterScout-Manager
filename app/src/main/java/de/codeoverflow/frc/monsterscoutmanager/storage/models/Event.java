package de.codeoverflow.frc.monsterscoutmanager.storage.models;

import java.util.Date;

/**
 *
 * Created by Alex on 17.02.2018.
 */

public class Event {

    //Class values
    private String key;
    private String eventCode;
    private String name;

    private int year;
    private int week;
    private String timezone;

    private Date startDate;
    private Date endDate;

    private String location;
    private String locationName;
    private String shortName;
    private String address;
    private String eventTypeString;
    private int eventType;
    private String city;
    private District district;
    private String districtKey;

    private String website;
    private String webcasts;

    private Long lastUpdated;

    /**
     * !Important! The Google Maps location service got disabled a
     */

    public Event(){
        startDate = null;
        endDate = null;
    }

    public int getWeek() {
        return week;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDistrictKey() {
        return districtKey;
    }

    public void setDistrictKey(String districtKey) {
        this.districtKey = districtKey;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeString() {
        return eventTypeString;
    }

    public void setEventTypeString(String eventTypeString) {
        this.eventTypeString = eventTypeString;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
