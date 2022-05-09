package com.github.goldfish07.vidstatus.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Msg {

    @SerializedName("tp")
    int tp;
    @SerializedName("uid")
    String uid;
    @SerializedName("liked")
    int liked;
    @SerializedName("score")
    long score;
    @SerializedName("status")
    String status;
    @SerializedName("is_block")
    int is_block;
    @SerializedName("description")
    String description;
    @SerializedName("country")
    String country;
    @SerializedName("city")
    String city;
    @SerializedName("_id")
    String _id;
    @SerializedName("id")
    String id;
    @SerializedName("fb_id")
    String fb_id;
    @SerializedName("user_info")
    UserInfo userInfo = new UserInfo();
    @SerializedName("count")
    Count count = new Count();
    @SerializedName("video")
    String video;
    @SerializedName("thum")
    String thum;
    @SerializedName("gif")
    String gif;
    @SerializedName("sound")
    Sound sound = new Sound();
    @SerializedName("created")
    String created;
    @SerializedName("__v")
    int __v;

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getIs_block() {
        return is_block;
    }


    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int isIs_block() {
        return is_block;
    }

    public void setIs_block(int is_block) {
        this.is_block = is_block;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Count getCount() {
        return count;
    }

    public void setCount(Count count) {
        this.count = count;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getThum() {
        return thum;
    }

    public void setThum(String thum) {
        this.thum = thum;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }
}
