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
public class UlunchAdapter  extends BaseAdapter{
    ArrayList<Ulunchlist> ulunchLists;
    Context context;
    LayoutInflater layoutInflater;

    public UlunchAdapter(UlunchActivity ulunchActivity, ArrayList<Ulunchlist> ulunchlists) {
        this.context = ulunchActivity;
        this.ulunchLists = ulunchlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return ulunchLists.size();
    }

    @Override
    public Object getItem(int position) {
        return ulunchLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_ulunch, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_ulunch_data);
        textView.setText(ulunchLists.get(position).getdata());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_ulunch_image);
        Picasso.with(context).load(ulunchLists.get(position).getImage()).into(imageView);
        return view;
    }
}
