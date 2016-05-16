package com.gennakersystems.diffhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserListActivity extends AppCompatActivity {

    private TextView mUsernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        mUsernameTextView = (TextView) findViewById(R.id.usernameTextView);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText("Repositories for the user: " + username);
    }
}
