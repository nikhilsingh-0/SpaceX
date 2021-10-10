package com.mk.nk.spacex;

import com.mk.nk.spacex.Room.Crew;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("crew")
    Call<List<CrewModel>> getModels();
}
