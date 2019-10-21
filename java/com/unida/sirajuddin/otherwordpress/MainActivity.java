package com.unida.sirajuddin.otherwordpress;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unida.sirajuddin.otherwordpress.Adapter.RecycleViewAdapter;
import com.unida.sirajuddin.otherwordpress.Model.Model;
import com.unida.sirajuddin.otherwordpress.RestApi.RetrofitArrayApi;
import com.unida.sirajuddin.otherwordpress.WPPost.WPPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String baseUrl = ("https://wp.harisdc.com");
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar progressBar;
    public ArrayList<Model> list;
    private RecycleViewAdapter adapter;
    private List<Model> models = new ArrayList<>();



    public static List<WPPost> mListPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);

        mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        list = new ArrayList<Model>();
        //call retrofit
        getRetrofit();

        adapter = new RecycleViewAdapter(list, MainActivity.this);

        recyclerView.setAdapter(adapter);

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

                Log.e("mainactivity", " response "+ response.body());

                mListPost = response.body();

                progressBar.setVisibility(View.GONE);

                for (int i=0; i <response.body().size();i++){

                    Log.e("main ", " title "+ response.body().get(i).getTitle().getRendered() + "" + response.body().get(i).getId());

                    String tempdetails =  response.body().get(i).getExcerpt().getRendered().toString();
                    tempdetails = tempdetails.replace("<p>","");
                    tempdetails = tempdetails.replace("</p>","");
                    tempdetails = tempdetails.replace("[&hellip;]","");

                    list.add( new Model( Model.IMAGE_TYPE,  response.body().get(i).getTitle().getRendered()+ "" ,
                            tempdetails,
                            response.body().get(9).getLinks().getWpFeaturedmedia().get(0).getHref())  );

                }
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {

            }
        });
    }


}
