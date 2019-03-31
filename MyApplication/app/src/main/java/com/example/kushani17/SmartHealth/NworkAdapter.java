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
public class NworkAdapter extends BaseAdapter{
    ArrayList<Nworklist> nworkLists;
    Context context;
    LayoutInflater layoutInflater;

    public NworkAdapter(NworkoutActivity NworkoutActivity, ArrayList<Nworklist> Nworklists) {
        this.context = NworkoutActivity;
        this.nworkLists = Nworklists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return nworkLists.size();
    }

    @Override
    public Object getItem(int position) {
        return nworkLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.custom_nwok, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_nwok_tip);
        ImageView imageView = (ImageView) view.findViewById(R.id.custom_nwok_image);
        textView.setText(nworkLists.get(position).getTip());
        Picasso.with(context).load(nworkLists.get(position).getImage()).into(imageView);
        return view;
    }
}
