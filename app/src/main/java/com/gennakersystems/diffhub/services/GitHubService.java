package com.gennakersystems.diffhub.services;

import android.util.Log;

import com.gennakersystems.diffhub.Constants;
import com.gennakersystems.diffhub.models.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitHubService {
    public static final String TAG = GitHubService.class.getSimpleName();


    public static void findUser(String username, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        String url = Constants.GH_USER_URL + username + Constants.GH_ACCESS_TOKEN;
        Log.d(TAG + " find user url", url);
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<User> processUser(Response response) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            Log.d(TAG+" jsonData", jsonData);
            if (response.isSuccessful()) {
                JSONObject ghJSON = new JSONObject(jsonData);
                String username = ghJSON.getString("login");
                Log.d(TAG, username);
                String name = ghJSON.getString("name");
                Log.d(TAG, name);
                String imageUrl = ghJSON.getString("avatar_url");
                Log.d(TAG, imageUrl);
                String email = ghJSON.getString("email");
                Log.d(TAG, email);
                String creationDate = ghJSON.getString("created_at");
                Log.d(TAG, creationDate);
                int repos = ghJSON.getInt("public_repos");
                Log.d(TAG, repos + "");
                int followers = ghJSON.getInt("followers");
                Log.d(TAG, followers + "");
                int following = ghJSON.getInt("following");
                Log.d(TAG, following + "");

                User user = new User(
                        username,
                        name,
                        imageUrl,
                        email,
                        creationDate,
                        repos,
                        followers,
                        following);
                users.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}