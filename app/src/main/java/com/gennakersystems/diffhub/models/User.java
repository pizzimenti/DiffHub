package com.gennakersystems.diffhub.models;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String mUsername;
    private String mName;
    private String mImageUrl;
    private String mEmail;
    private String mCreationDate;
    private int mRepos;
    private int mFollowers;
    private int mFollowing;

    public User(String username, String name, String imageUrl, String email, String creationDate, int repos, int followers, int following) {
        this.mUsername = username;
        this.mName = name;
        this.mImageUrl = imageUrl;
        this.mEmail = email;
        this.mCreationDate = creationDate;
        this.mRepos = repos;
        this.mFollowers = followers;
        this.mFollowing = following;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getName() {
        return mName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getCreationDate() {
        return mCreationDate;
    }

    public int getRepos() {
        return mRepos;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public int getFollowing() {
        return mFollowing;
    }


    public static Date getFormattedDate(String creationDate) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(creationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}