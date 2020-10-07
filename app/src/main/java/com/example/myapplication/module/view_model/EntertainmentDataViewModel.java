package com.example.myapplication.module.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.base.APIEndPoints;
import com.example.myapplication.base.RestApiService;
import com.example.myapplication.module.model.EntertainmentModel;
import com.example.myapplication.module.model.EntertainmentzModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentDataViewModel extends AndroidViewModel {

    APIEndPoints service = RestApiService.getRetrofitInstance().create(APIEndPoints.class);
    private MutableLiveData<EntertainmentzModel> livedata = new MutableLiveData<>();

    public EntertainmentDataViewModel(@NonNull Application application) {
        super(application);
        getResponse();
    }

    public void getResponse() {
        Call<EntertainmentzModel> callPost = service.getEntertainmentDetails();
        callPost.enqueue(new Callback<EntertainmentzModel>() {
            @Override
            public void onResponse(Call<EntertainmentzModel> call, Response<EntertainmentzModel> response) {
                Log.e("Success response","");

                livedata.postValue(response.body());
            }

            @Override
            public void onFailure(Call<EntertainmentzModel> call, Throwable t) {

                Log.e("FAILED","");
            }
        });
    }

    public MutableLiveData<EntertainmentzModel>getPostMutableLiveData(){
        return livedata;
    }
}
