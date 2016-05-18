package com.gennakersystems.diffhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserListActivity extends AppCompatActivity {
    public static final String TAG = UserListActivity.class.getSimpleName();
    public ArrayList<User> mUsers = new ArrayList<>();
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.usernameTextView) TextView mUsernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, mUsers);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String user = ((TextView) view).getText().toString();
                Toast.makeText(UserListActivity.this, user, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsernameTextView.setText("Repositories for the user: " + username);
        getUser(username);

    }

    private void getUser(final String username) {
        GitHubService.findUser(username, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mUsers = GitHubService.processUser(response);

                UserListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] userNames = new String[mUsers.size()];
                        for (int i = 0; i < userNames.length; i++) {
                            userNames[i] = mUsers.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(UserListActivity.this, android.R.layout.simple_list_item_1, userNames);
                        mListView.setAdapter(adapter);

                    }
                });
            }
        });
    }
}
