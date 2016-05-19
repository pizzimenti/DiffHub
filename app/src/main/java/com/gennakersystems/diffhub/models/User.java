package com.gennakersystems.diffhub.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String mUsername;
    private String mFullName;
    private String mImageUrl;
    private String mEmail;
    private String mCreationDate;
    private int mRepoCount;
    private int mFollowers;
    private int mFollowing;

    public User(String username, String fullname, String imageUrl, String email, String creationDate, int repocount, int followers, int following) {
        this.mUsername = username;
        this.mFullName = fullname;
        this.mImageUrl = imageUrl;
        this.mEmail = email;
        this.mCreationDate = creationDate;
        this.mRepoCount = repocount;
        this.mFollowers = followers;
        this.mFollowing = following;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getFullname() {
        return mFullName;
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

    public int getRepoCount() {
        return mRepoCount;
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