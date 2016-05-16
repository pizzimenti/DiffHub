package com.gennakersystems.diffhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Button mFindUserButton;
    private EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = (EditText) findViewById(R.id.usernameEditText);
        mFindUserButton = (Button) findViewById(R.id.findUserButton);
        mFindUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUserName.getText().toString();
                Intent intent = new Intent(MainActivity.this, UserListActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}
