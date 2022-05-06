package com.github.goldfish07.vidstatus.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Vid {

    @SerializedName("server")
    String server;

    @SerializedName("code")
    int code;

    @SerializedName("msg")
    List<Msg> msg = new ArrayList<>();

    public Vid() {
        super();
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Msg> getMsg() {
        return msg;
    }

    public void setMsg(List<Msg> msg) {
        this.msg = msg;
    }
}
