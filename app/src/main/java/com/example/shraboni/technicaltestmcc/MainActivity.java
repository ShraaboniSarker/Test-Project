package com.example.shraboni.technicaltestmcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;


import com.example.shraboni.technicaltestmcc.adapter.DataAdapter;
import com.example.shraboni.technicaltestmcc.model.Contentfilelist;
import com.example.shraboni.technicaltestmcc.model.DataResponse;
import com.example.shraboni.technicaltestmcc.network.APIService;
import com.example.shraboni.technicaltestmcc.network.RetrofitClientInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public APIService apiService;
    List<Contentfilelist> list;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiService = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);

        getData();

    }

    public void getData() {

        Call<DataResponse> call = apiService.getAllPhotos(9,35);
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()){
                    list = response.body().getContentfilelist();
                    adapterAttached(list);
                    Toast.makeText(MainActivity.this, "Successfully retrieve data !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Unsuccessfully attempt retrieve data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, " Error !", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void adapterAttached(List<Contentfilelist> listing){

        adapter = new DataAdapter(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //activityIndicator.setVisibility(View.GONE);
        LinearLayoutManager recyce = new LinearLayoutManager(MainActivity.this);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(recyce);
    }

}
