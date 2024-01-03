package com.example.recycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recycler.model.ApiResponse;
import com.example.recycler.model.LugarTuristico;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProductos;
    private LugarTuristicoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvProductos = findViewById(R.id.rvProductos);
        rvProductos.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://uealecpeterson.net/turismo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<ApiResponse> call = apiService.getLugarTuristico();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call,
                                    Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    if (apiResponse != null) {
                        List<LugarTuristico> lugaresTuristicos = apiResponse.getData();
                        if (lugaresTuristicos != null && lugaresTuristicos.isEmpty()) {
                            adapter = new LugarTuristicoAdapter(lugaresTuristicos);
                            rvProductos.setAdapter(adapter);
                        } else {
                            Toast.makeText(MainActivity.this, "No hay datos disponibles",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this,
                                    "No hay datos disponibles", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Log.e("MainActivity", "Error en la respuesta de la API: " + response.code());
                    }
                }
                else {
                    // Mostrar un mensaje de error en caso de respuesta no exitosa
                    Log.e("MainActivity", "Error en la respuesta de la API: " + response.code());
                    Toast.makeText(MainActivity.this, "Error en la respuesta de la API: "
                            + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e("APIError", "Error en la respuesta  FALLA de la API", t);
                Toast.makeText(MainActivity.this, "Error al obtener datos de la API",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}



