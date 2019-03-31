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
public class NlunchAdapter extends BaseAdapter {
    ArrayList<Nlunchlist> nlunchLists;
    Context context;
    LayoutInflater layoutInflater;

    public NlunchAdapter(NlunchActivity nlunchActivity, ArrayList<Nlunchlist> nlunchlists) {
        this.context = nlunchActivity;
        this.nlunchLists = nlunchlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return nlunchLists.size();
    }

    @Override
    public Object getItem(int position) {
        return nlunchLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_nlunch, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_nlunch_data);
        textView.setText(nlunchLists.get(position).getdata());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_nlunch_image);
        Picasso.with(context).load(nlunchLists.get(position).getImage()).into(imageView);

        return view;
    }
}
