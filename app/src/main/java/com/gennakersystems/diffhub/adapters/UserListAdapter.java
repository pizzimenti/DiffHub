package com.gennakersystems.diffhub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gennakersystems.diffhub.R;
import com.gennakersystems.diffhub.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private ArrayList<User> mUsers = new ArrayList<>();
    private Context mContext;

    public UserListAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        mUsers = users;
    }

    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.UserViewHolder holder, int position) {
        holder.bindUser(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.userImageView) ImageView mUserImageView;
        @BindView(R.id.usernameTextView) TextView mUsernameTextView;
        @BindView(R.id.userFullNameTextView) TextView mUserFullNameTextView;
        @BindView(R.id.repoCountTextView) TextView mRepoCountTextView;
        @BindView(R.id.userSinceTextView) TextView mUserSinceTextView;
        private Context mContext;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindUser(User user) {
            Picasso.with(mContext).load(user.getImageUrl()).into(mUserImageView);
            mUsernameTextView.setText(user.getUsername());
            mUserFullNameTextView.setText(user.getFullname());
            mRepoCountTextView.setText("Public repos: " + user.getRepoCount());
            mUserSinceTextView.setText("Joined GitHub: " + user.getCreationDate());
        }
    }
}
