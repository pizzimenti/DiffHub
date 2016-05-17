package com.gennakersystems.diffhub;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ghService {
    public static final String TAG = ghService.class.getSimpleName();

    public static final String GH_BASE_URL = "https://api.github.com/";
    public        static final String GH_USER_QUERY_PARAMETER = GH_BASE_URL + "users/";

    public static void findUser(String username, Callback callback) {

        OkHttpClient client = new OkHttpClient();

//        HttpUrl.Builder urlBuilder = HttpUrl.parse(GH_BASE_URL).newBuilder();
//        urlBuilder.addQueryParameter(GH_USER_QUERY_PARAMETER, username);
//        URLbuilder is unnecessary because GH URLs do not have query structure

        String url = GH_USER_QUERY_PARAMETER + username;
        Log.d(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
