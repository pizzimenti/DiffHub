package com.gennakersystems.diffhub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.gennakersystems.diffhub.models.User;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private ArrayList<User> mUsers = new ArrayList<>();
    private Context mContext;

    public UserListAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        mUsers = users;
    }
}
