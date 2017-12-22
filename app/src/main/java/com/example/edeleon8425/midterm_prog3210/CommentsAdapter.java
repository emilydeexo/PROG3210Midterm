package com.example.edeleon8425.midterm_prog3210;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CommentsAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<User> use;

    public CommentsAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context,textViewResourceId, objects);

        this.context= context;
        use=objects;

    }

    private class ViewHolder
    {
        TextView name;
        TextView comment;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder=null;
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.layout_comments, null);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.comment=(TextView)convertView.findViewById(R.id.comment);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        User individualUser= use.get(position);
        holder.name.setText(individualUser.getName()+"");
        holder.comment.setText(individualUser.getComment());
        return convertView;


    }
}
