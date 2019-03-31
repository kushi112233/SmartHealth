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
 * Created by Kushani17 on 4/12/2017.
 */
public class OlunchAdapter extends BaseAdapter {
    ArrayList<Olunchlist> olunchLists;
    Context context;
    LayoutInflater layoutInflater;

    public OlunchAdapter(OlunchActivity olunchActivity, ArrayList<Olunchlist> olunchlists) {
        this.context = olunchActivity;
        this.olunchLists = olunchlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return olunchLists.size();
    }

    @Override
    public Object getItem(int position) {
        return olunchLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_olunch, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_olunch_data);
        textView.setText(olunchLists.get(position).getdata());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_olunch_image);
        Picasso.with(context).load(olunchLists.get(position).getImage()).into(imageView);
        return view;

    }
}
