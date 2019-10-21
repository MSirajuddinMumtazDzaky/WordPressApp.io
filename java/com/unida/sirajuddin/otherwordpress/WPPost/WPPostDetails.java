package com.unida.sirajuddin.otherwordpress.WPPost;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unida.sirajuddin.otherwordpress.Adapter.RecycleViewAdapter;
import com.unida.sirajuddin.otherwordpress.Model.Model;
import com.unida.sirajuddin.otherwordpress.R;
import com.unida.sirajuddin.otherwordpress.RestApi.RetrofitArrayApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WPPostDetails extends AppCompatActivity {

    private String baseUrl = ("https://wp.harisdc.com");

    public ArrayList<Model> list;
    private RecycleViewAdapter adapter;
    private List<Model> models = new ArrayList<>();
    public static TextView PostTitle ;
    public static TextView Date ;
    public static TextView Author;
    public static TextView Content;




    public static List<WPPost> mListPost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdetails);


        PostTitle = findViewById(R.id.PostTitle);
        Date = findViewById(R.id.date);
        Author = findViewById(R.id.author);
        Content = findViewById(R.id.Content);

        getRetrofit();
    }
    public void getRetrofit()  {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        Call<List<WPPost>> call = service.getPostInfo();

        call.enqueue(new Callback<List<WPPost>>() {

            @Override
            public void onResponse(Call<List<WPPost>> call, Response<List<WPPost>> response) {




            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {

            }
        });
    }



}
