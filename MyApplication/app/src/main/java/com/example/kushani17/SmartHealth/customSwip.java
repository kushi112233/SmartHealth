package com.example.kushani17.SmartHealth;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Kushani17 on 3/17/2017.
 */
public class customSwip extends PagerAdapter {
    Context ctx;
    LayoutInflater layoutInflater;
    ArrayList<Setget> arrayList;

    public customSwip(Context c, ArrayList<Setget> arrayList) {
        this.ctx = c;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.activity_custom_swip, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.swip_image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.imagecount);
        imageView.setImageResource(arrayList.get(position).getImages());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
