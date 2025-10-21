package com.example.fragpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() { return userList.size(); }

    @Override
    public Object getItem(int position) { return userList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);

        User user = userList.get(position);
        TextView nameView = convertView.findViewById(R.id.ItemName);
        TextView statusView = convertView.findViewById(R.id.ItemState);
        FrameLayout signalView = convertView.findViewById(R.id.StateRound);

        switch (user.getStateSignal()) {
            case 0:
                signalView.setBackgroundResource(R.drawable.back_offline);
            case 1:
                signalView.setBackgroundResource(R.drawable.back_online);
            case 2:
                signalView.setBackgroundResource(R.drawable.back_departed);
        }

        nameView.setText(user.getName());
        statusView.setText(user.getStatus());
        return convertView;
    }
}
