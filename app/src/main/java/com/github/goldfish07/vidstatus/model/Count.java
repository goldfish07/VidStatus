package com.github.goldfish07.vidstatus.model;

import com.google.gson.annotations.SerializedName;

public class Count {

    @SerializedName("like_count")
    long like_count;
    @SerializedName("video_comment_count")
    long video_comment_count;
    @SerializedName("view")
    long view;
    @SerializedName("_id")
    String _id;

    public long getLike_count() {
        return like_count;
    }

    public void setLike_count(long like_count) {
        this.like_count = like_count;
    }

    public long getVideo_comment_count() {
        return video_comment_count;
    }

    public void setVideo_comment_count(long video_comment_count) {
        this.video_comment_count = video_comment_count;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
