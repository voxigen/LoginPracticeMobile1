package com.example.fragpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    private EditText nameEditText, stateEditText, ageEditText;
    private User activeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        nameEditText = findViewById(R.id.NameTextView);
        stateEditText = findViewById(R.id.StateTextView);
        ageEditText = findViewById(R.id.AgeTextView);

        int position = getIntent().getIntExtra("USER_POSITION", -1);
        if (position != -1) {
            activeUser = UserStaticInfo.userList.get(position);
            Init(activeUser);
        }
    }

    private void Init(User user) {
        nameEditText.setText(user.getName());
        stateEditText.setText(user.getStatus());
        ageEditText.setText(String.valueOf(user.getAge()));
    }

    public void saveUserInfo(View view) {
        if (activeUser != null) {
            activeUser.setName(nameEditText.getText().toString());
            activeUser.setStatus(stateEditText.getText().toString());
            String ageText = ageEditText.getText().toString();
            if (!ageText.isEmpty()) activeUser.setAge(Integer.parseInt(ageText));
        }
        finish();
    }

    public void Back(View view) {
        finish();
    }
}
