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
public class OdinnerAdapter extends BaseAdapter{
    ArrayList<Odinnerlist> odinnerLists;
    Context context;
    LayoutInflater layoutInflater;

    public OdinnerAdapter(OdinnerActivity odinnerActivity, ArrayList<Odinnerlist> odinnerlists) {
        this.context = odinnerActivity;
        this.odinnerLists = odinnerlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return odinnerLists.size();
    }

    @Override
    public Object getItem(int position) {
        return odinnerLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_odinner, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_odinner_top);
        textView.setText(odinnerLists.get(position).getTop());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_odinner_image);
        Picasso.with(context).load(odinnerLists.get(position).getImage()).into(imageView);
        return view;

    }
}
