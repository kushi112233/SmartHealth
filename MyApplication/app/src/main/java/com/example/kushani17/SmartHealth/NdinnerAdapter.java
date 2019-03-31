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
public class NdinnerAdapter  extends BaseAdapter{
    ArrayList<Ndinnerlist> ndinnerLists;
    Context context;
    LayoutInflater layoutInflater;

    public NdinnerAdapter(NdinnerActivity ndinnerActivity, ArrayList<Ndinnerlist> ndinnerlists) {
        this.context = ndinnerActivity;
        this.ndinnerLists = ndinnerlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return ndinnerLists.size();
    }

    @Override
    public Object getItem(int position) {
        return ndinnerLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_ndinner, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_ndinner_top);
        textView.setText(ndinnerLists.get(position).getTop());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_ndinner_image);
        Picasso.with(context).load(ndinnerLists.get(position).getImage()).into(imageView);

        return view;

    }
}
