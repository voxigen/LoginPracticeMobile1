package com.example.fragpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    LayoutInflater layoutInflater;
    FrameLayout userPanel;


    static TextView nameTextView;
    static TextView stateTextView;
    static TextView ageTextView;

    static int positionActiveUser = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        UserStaticInfo.addUsersIfNeeded();
        Init();
    }

    private void Init() {
        userPanel = findViewById(R.id.userPanel);
        listView = findViewById(R.id.MainListView);
        context = this;
        layoutInflater = LayoutInflater.from(context);

        nameTextView = findViewById(R.id.NameTextView);
        stateTextView = findViewById(R.id.StateTextView);
        ageTextView = findViewById(R.id.AgeTextView);

        UserListAdapter adapter = new UserListAdapter(context, UserStaticInfo.userList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            positionActiveUser = position;
            User user = UserStaticInfo.userList.get(position);
            InitPanel(user);
            UserVisibility(true);
        });
    }

    public void BackTolist(View view) {
        UserVisibility(false);
    }

    private void UserVisibility(boolean visible) {
        userPanel.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public static void UpdateListAndUserPanel(User user) {
        if (nameTextView != null && stateTextView != null && ageTextView != null) {
            nameTextView.setText(user.getName());
            stateTextView.setText(user.getStatus());
            ageTextView.setText(String.valueOf(user.getAge()));
        }
    }

    public void EditUser(View view) {
        if (positionActiveUser >= 0) {
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            intent.putExtra("USER_POSITION", positionActiveUser);
            startActivity(intent);
        }
    }

    public void InitPanel(User user) {
        nameTextView.setText(user.getName());
        stateTextView.setText(user.getStatus());
        ageTextView.setText(String.valueOf(user.getAge()));
    }
}
