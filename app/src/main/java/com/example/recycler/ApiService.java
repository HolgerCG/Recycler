package com.example.recycler;

import com.example.recycler.model.ApiResponse;
import com.example.recycler.model.LugarTuristico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService{
    @GET("lugar_turistico/json_getlistadoGrid")
    Call<ApiResponse> getLugarTuristico();

}
