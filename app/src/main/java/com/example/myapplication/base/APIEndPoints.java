package com.example.myapplication.base;

import com.example.myapplication.module.model.EntertainmentzModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndPoints {
    @GET("/api/v1/rss/entertainment/rss.xml")
    Call<EntertainmentzModel> getEntertainmentDetails();
}
