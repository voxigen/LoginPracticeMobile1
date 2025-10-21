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
    TextView nameTextView, stateTextView, ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        UserStaticInfo.addUsersIfNeeded();
        Init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listView != null) {
            UserListAdapter adapter = (UserListAdapter) listView.getAdapter();
            if (adapter != null) adapter.notifyDataSetChanged();
        }
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
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            intent.putExtra("USER_POSITION", position);
            startActivity(intent);
        });
    }
}
