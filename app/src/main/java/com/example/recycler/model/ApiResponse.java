package com.example.recycler.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("data")
    private List<LugarTuristico> data;

    public List<LugarTuristico> getData() {
        return data;
    }
    public void setData(List<LugarTuristico> data) {
        this.data = data;
    }
}
