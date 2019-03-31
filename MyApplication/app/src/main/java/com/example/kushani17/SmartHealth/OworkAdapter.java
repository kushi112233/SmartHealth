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
public class OworkAdapter extends BaseAdapter {

    ArrayList<Oworklist> oworkLists;
    Context context;
    LayoutInflater layoutInflater;

    public OworkAdapter(OworkoutActivity OworkoutActivity, ArrayList<Oworklist> Oworklists) {
        this.context = OworkoutActivity;
        this.oworkLists = Oworklists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return oworkLists.size();
    }

    @Override
    public Object getItem(int position) {
        return oworkLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_owok, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_owok_tip);
        textView.setText(oworkLists.get(position).getTip());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_owok_image);
        Picasso.with(context).load(oworkLists.get(position).getImage()).into(imageView);
        return view;

    }
}
