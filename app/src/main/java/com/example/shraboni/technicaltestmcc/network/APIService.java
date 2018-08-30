package com.example.shraboni.technicaltestmcc.network;



import com.example.shraboni.technicaltestmcc.model.DataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface APIService {

    @POST("/mobsvc/ContentFile.php")
    Call<DataResponse> getAllPhotos();
}
