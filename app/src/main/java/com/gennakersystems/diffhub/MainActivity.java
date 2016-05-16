package com.gennakersystems.diffhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.findUserButton) Button mFindUserButton;
    @BindView(R.id.usernameEditText) EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mFindUserButton) {
            String username = mUserName.getText().toString();
            Intent intent = new Intent(MainActivity.this, UserListActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
    }
}