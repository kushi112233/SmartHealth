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
public class NbreakAdapter extends BaseAdapter{
    ArrayList<Nbreaklist> nbreakLists;
    Context context;
    LayoutInflater layoutInflater;

    public NbreakAdapter(NbreakfastActivity nbreakActivity, ArrayList<Nbreaklist> nbreaklists) {
        this.context = nbreakActivity;
        this.nbreakLists = nbreaklists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return nbreakLists.size();
    }

    @Override
    public Object getItem(int position) {
        return nbreakLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_nbreak, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_nbreak_tok);
        textView.setText(nbreakLists.get(position).getTok());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_nbreak_image);
        Picasso.with(context).load(nbreakLists.get(position).getImage()).into(imageView);
        return view;
    }
}
