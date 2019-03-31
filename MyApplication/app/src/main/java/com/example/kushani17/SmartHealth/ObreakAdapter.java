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
public class ObreakAdapter extends BaseAdapter {

    ArrayList<Obreaklist> obreakLists;
    Context context;
    LayoutInflater layoutInflater;

    public ObreakAdapter(ObreakfastActivity obreakActivity, ArrayList<Obreaklist> obreaklists) {
        this.context = obreakActivity;
        this.obreakLists = obreaklists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return obreakLists.size();
    }

    @Override
    public Object getItem(int position) {
        return obreakLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_obreak, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_obreak_tok);
        textView.setText(obreakLists.get(position).getTok());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_obreak_image);
        Picasso.with(context).load(obreakLists.get(position).getImage()).into(imageView);
        return view;

    }
}
