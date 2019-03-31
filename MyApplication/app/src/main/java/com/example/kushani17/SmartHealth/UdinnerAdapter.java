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
public class UdinnerAdapter  extends BaseAdapter{

    ArrayList<Udinnerlist> udinnerLists;
    Context context;
    LayoutInflater layoutInflater;

    public UdinnerAdapter(UdinnerActivity udinnerActivity, ArrayList<Udinnerlist> udinnerlists) {
        this.context = udinnerActivity;
        this.udinnerLists = udinnerlists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {

        return udinnerLists.size();
    }

    @Override
    public Object getItem(int position) {
      return  udinnerLists.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_udinner, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_udinner_top);
        textView.setText(udinnerLists.get(position).getTop());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_udinner_image);
        Picasso.with(context).load(udinnerLists.get(position).getImage()).into(imageView);
        return view;
    }
}
