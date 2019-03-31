package com.example.kushani17.SmartHealth;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kushani17 on 4/7/2017.
 */
public class UyogaAdapter extends BaseAdapter {
    ArrayList<Uyogalist> uyogaLists;
    Context context;
    LayoutInflater layoutInflater;

    public UyogaAdapter(UyogaActivity uyogaActivity, ArrayList<Uyogalist> uyogalists) {
        this.context = uyogaActivity;
        this.uyogaLists = uyogalists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public UyogaAdapter(UbreakfastActivity ubreakfastActivity, ArrayList<Ubreaklist> ubreakists) {

    }


    @Override
    public int getCount() {
        return uyogaLists.size();
    }

    @Override
    public Object getItem(int position) {
        return uyogaLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_uyoga, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_uyoga_todo);
        textView.setText(uyogaLists.get(position).getTodo());
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_uyoga_image);
        Picasso.with(context).load(uyogaLists.get(position).getImage()).into(imageView);

        return view;
    }

}