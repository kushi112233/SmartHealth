package com.example.kushani17.SmartHealth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kushani17 on 4/10/2017.
 */
public class UbreakAdapter extends BaseAdapter {
    ArrayList<Ubreaklist> ubreakLists;
    Context context;
    LayoutInflater layoutInflater;

    public UbreakAdapter(UbreakfastActivity ubreakActivity, ArrayList<Ubreaklist> ubreaklists) {
        this.context = ubreakActivity;
        this.ubreakLists = ubreaklists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return ubreakLists.size();
    }

    @Override
    public Object getItem(int position) {
        return ubreakLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_ubreak, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_ubreak_tip);
        textView.setText(ubreakLists.get(position).getTip());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_ubreak_image);
        Picasso.with(context).load(ubreakLists.get(position).getImage()).into(imageView);
        return view;

    }
}
