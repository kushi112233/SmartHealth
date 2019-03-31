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
 * Created by Kushani17 on 4/6/2017.
 */
public class UworkOutAdapter extends BaseAdapter {
    
    ArrayList<UworkoutList> uworkoutLists;
    Context context;
    LayoutInflater layoutInflater;

    public UworkOutAdapter(UworkoutActivity uworkoutActivity, ArrayList<UworkoutList> uworkoutLists) {
        this.context = uworkoutActivity;
        this.uworkoutLists = uworkoutLists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return uworkoutLists.size();
    }

    @Override
    public Object getItem(int position) {
        return uworkoutLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_uwok,null);
        TextView textView = (TextView) view.findViewById(R.id.custom_uwork_tips1);
        textView.setText(uworkoutLists.get(position).getTips1());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_uwok_image);
        Picasso.with(context).load(uworkoutLists.get(position).getImage()).into(imageView);
        return view;
    }
}
