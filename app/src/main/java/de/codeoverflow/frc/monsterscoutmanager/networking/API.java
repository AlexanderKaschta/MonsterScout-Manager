package de.codeoverflow.frc.monsterscoutmanager.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @version 1.0
 * Created by Alex on 24.02.2018.
 */

public class API {

    public static TBAApi getInstance(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .addHeader("X-TBA-Auth-Key", ApiConstants.TBA_Auth_Key)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thebluealliance.com/api/v3/")
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(TBAApi.class);
    }

}
