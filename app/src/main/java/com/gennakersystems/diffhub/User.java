package com.gennakersystems.diffhub;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String mUsername;
    private String mName;
    private String mImageUrl;
    private String mEmail;
    private Date mCreationDate;
    private int mRepos;
    private int mFollowers;
    private int mFollowing;

    public User(String username, String name, String imageUrl, String email, Date creationDate, int repos, int followers, int following) {
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

    public Date getCreationDate() {
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

    public Date getFormattedDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date date = format.parse("blah");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}