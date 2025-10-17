package com.example.fragpractice;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Context context;
    LayoutInflater layoutInflater;
    FrameLayout UserPanel;
    List<User> userList = new ArrayList<>();

    TextView nameTextView;
    TextView stateTextView;
    TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AddUserInList();
        Init();
    }

    private void AddUserInList() {
        userList.add(new User(25, "Good", "Van", 0));
        userList.add(new User(18, "Good", "Nan", 1));
        userList.add(new User(24, "Bad", "Fun", 2));
        userList.add(new User(29, "Mid", "Van2",1 ));
        userList.add(new User(23, "Good", "Van3", 2));
    }

    private void Init() {
        UserPanel = findViewById(R.id.userPanel);
        listView = findViewById(R.id.MainListView);
        context = this;
        layoutInflater = LayoutInflater.from(context);

        nameTextView = findViewById(R.id.NameTextView);
        stateTextView = findViewById(R.id.StateTextView);
        ageTextView = findViewById(R.id.AgeTextView);

        UserListAdapter userListAdapter = new UserListAdapter(context, userList);
        listView.setAdapter(userListAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            User clickedUser = userList.get(position);
            InitPanel(clickedUser);
            UserVisibility(true);
        });
    }


    public void BackTolist(View view) {
        UserVisibility(false);
    }

    private void UserVisibility(boolean b) {
        if (b) {
            UserPanel.setVisibility(View.VISIBLE);
        } else {
            UserPanel.setVisibility(View.GONE);
        }
    }

    public void InitPanel(User item) {
        nameTextView.setText(item.getName());
        stateTextView.setText(item.getStatus());
        ageTextView.setText(String.valueOf(item.getAge()));
    }
}
