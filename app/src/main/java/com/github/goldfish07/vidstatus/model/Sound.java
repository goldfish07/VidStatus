package com.github.goldfish07.vidstatus.model;

import com.google.gson.annotations.SerializedName;

public class Sound {

    @SerializedName("id")
    int id;
    @SerializedName("sound_name")
    String sound_name;
    @SerializedName("description")
    String description;
    @SerializedName("thum")
    String thum;
    @SerializedName("section")
    String section;
    @SerializedName("_id")
    String _id;
    @SerializedName("created")
    String created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSound_name() {
        return sound_name;
    }

    public void setSound_name(String sound_name) {
        this.sound_name = sound_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
