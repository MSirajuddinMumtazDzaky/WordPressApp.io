package com.unida.sirajuddin.otherwordpress.RestApi;



import com.unida.sirajuddin.otherwordpress.WPPost.WPPost;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayApi {

    @GET("rest-api/wp-json/wp/v2/posts")
    Call<List<WPPost>> getPostInfo();



}
