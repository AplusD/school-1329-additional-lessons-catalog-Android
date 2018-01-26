package com.aplusd.school_1329_extra_classes_catalogue.model;

import com.aplusd.school_1329_extra_classes_catalogue.viewmodels.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author Azamat Dzhonov
 * @date 08.01.2018
 */


public class ExtraClass implements Serializable{

    private boolean isFree = false;
    private String name = null;
    private String activityType = null;
    private String teacherName = null;


    public String auditoreAge = null;
    private String auditoreClasses = null;
    private String activityForm = null;
    private String hoursInWeek = null;
    private String priceForMonth = null;
    private String priceForYear = null;
    private String address = null;
    private String contacts = null;
    private String durationDates = null;


    public ExtraClass(String json, Boolean isFree)
    {
        this.isFree = isFree;
        try
        {
            JSONObject jsonObject = new JSONObject(json);
            if(jsonObject.has(Config.FIELD_NAME))
                name = jsonObject.getString(Config.FIELD_NAME);
            if(jsonObject.has(Config.FIELD_ACTIVITY_TYPE))
                activityType = jsonObject.getString(Config.FIELD_ACTIVITY_TYPE);
            if(jsonObject.has(Config.FILED_TEACHER_NAME))
                teacherName = jsonObject.getString(Config.FILED_TEACHER_NAME);

            if(jsonObject.has(Config.FIELD_AUDITORE_AGE))
                auditoreAge = jsonObject.getString(Config.FIELD_AUDITORE_AGE);
            if(jsonObject.has(Config.FIELD_AUDITORE_CLASSES))
                auditoreClasses = jsonObject.getString(Config.FIELD_AUDITORE_CLASSES);
            if(jsonObject.has(Config.FIELD_ACTIVITYFORM))
                activityForm = jsonObject.getString(Config.FIELD_ACTIVITYFORM);
            if(jsonObject.has(Config.FILED_HOURS_IN_WEEK))
                hoursInWeek = jsonObject.getString(Config.FILED_HOURS_IN_WEEK);
            if(jsonObject.has(Config.FIELD_PRICE_FOR_MONTH))
                priceForMonth = jsonObject.getString(Config.FIELD_PRICE_FOR_MONTH);
            if(jsonObject.has(Config.FIELD_PRICE_FOR_YEAR))
                priceForYear = jsonObject.getString(Config.FIELD_PRICE_FOR_YEAR);
            if(jsonObject.has(Config.FIELD_ADDRESS))
                address = jsonObject.getString(Config.FIELD_ADDRESS);
            if(jsonObject.has(Config.FIELD_CONTACTS))
                contacts = jsonObject.getString(Config.FIELD_CONTACTS);
            if(jsonObject.has(Config.FIELD_DURATION_DATES))
                durationDates = jsonObject.getString(Config.FIELD_DURATION_DATES);
        }
        catch (JSONException ex)
        {
            ex.printStackTrace();
        }
    }

    public boolean isFree() {
        return isFree;
    }

    public String getName() {
        return name;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getAuditoreAge() {
        return auditoreAge;
    }

    public String getAuditoreClasses() {
        return auditoreClasses;
    }

    public String getActivityForm() {
        return activityForm;
    }

    public String getHoursInWeek() {
        return hoursInWeek;
    }

    public String getPriceForMonth() {
        return priceForMonth;
    }

    public String getPriceForYear() {
        return priceForYear;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getDurationDates() {
        return durationDates;
    }
}
