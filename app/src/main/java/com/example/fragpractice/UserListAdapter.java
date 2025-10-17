package com.example.fragpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context, List<User> userList) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User currentUser = userList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }
        TextView nameView = convertView.findViewById(R.id.ItemName);
        TextView statusView = convertView.findViewById(R.id.ItemState);
        FrameLayout imageView = convertView.findViewById(R.id.StateRound);


        switch (currentUser.getStateSignal()) {
            case 0:
                imageView.setBackgroundResource(R.drawable.back_offline);
                break;
            case 1:
                imageView.setBackgroundResource(R.drawable.back_online);
                break;
            case 2:
                imageView.setBackgroundResource(R.drawable.back_departed);
                break;


        }
        nameView.setText(currentUser.getName());
        statusView.setText(currentUser.getStatus());




        return convertView;
    }
}
